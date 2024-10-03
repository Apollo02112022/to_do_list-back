package com.back.to_do_list_back.service;

import com.back.to_do_list_back.entity.TaskEntity;
import com.back.to_do_list_back.mapper.TaskMapper;
import com.back.to_do_list_back.model.TaskModel;
import com.back.to_do_list_back.model.TaskUpdateModel;
import com.back.to_do_list_back.error.NoTasksFoundException;
import com.back.to_do_list_back.error.TaskNotFoundException;
import com.back.to_do_list_back.repository.TaskRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {

    private TaskRepository taskRepository;

    private TaskMapper mapper;

    // CREATE

    /**
     * Method used to create a task.
     * @param model Model object
     * @return Model object
     * @throws IllegalArgumentException if the id is null or non-positive.
     * @throws DataAccessException if there is an error accessing the database.
     */
    @Override
    public TaskModel createATask(TaskModel model) {
        if (model == null || model.getTitle() == null || model.getTitle().isEmpty()) {
            throw new IllegalArgumentException("Task title cannot be null or empty.");
        }
        try {
            TaskEntity entity = mapper.modelToEntity(model);
            TaskEntity savedEntity = taskRepository.save(entity);
            return mapper.entityToModel(savedEntity);
        } catch (DataAccessException dae) {
            log.error("Error while trying to save task: ", dae);
            throw dae;
        }
    }

    // READ

    /**
     * Method used to display all tasks.
     * @return List<TaskEntity> Collection
     * @throws NoTasksFoundException if no tasks are found.
     * @throws DataAccessException if there is an error accessing the database.
     */
    @Override
    public List<TaskModel> displayAllTasks() {
        try {
            List<TaskEntity> taskEntities = taskRepository.findAll();
            if (taskEntities.isEmpty()) {
                log.info("No tasks found in the database.");
                throw new NoTasksFoundException("No tasks available.");
            }
            return mapper.listEntityToListModel(taskEntities);
        } catch (DataAccessException dae) {
            log.error("Error accessing data when retrieving all tasks.", dae);
            throw dae;
        }
    }

    /**
     * Method used to display a task by its id.
     * @param id Identification
     * @return Model object
     * @throws IllegalArgumentException if the id is null or non-positive.
     * @throws TaskNotFoundException if the task with the specified id is not found.
     * @throws DataAccessException if there is an error accessing the database.
     */
    @Override
    public TaskModel displayTaskById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("The task identifier must be positive and not null.");
        }
        try {
            TaskEntity entity = taskRepository.findById(id)
                    .orElseThrow(() -> new TaskNotFoundException("Task not found for id: " + id));
            return mapper.entityToModel(entity);
        } catch (DataAccessException dae) {
            log.error("Data access error when searching for task with id : " + id, dae);
            throw dae;
        }
    }

    // UPDATE

    /**
    * Method used to update a task by its id.
     * @param id Identification
     * @param Model object
     * @return Model object
     * @throws IllegalArgumentException if the id is null or non-positive.
     * @throws TaskNotFoundException if the task with the specified id is not found.
     * @throws DataAccessException if there is an error accessing the database.
     */
    @Override
    public TaskModel updateTask(Long id, TaskUpdateModel update) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("The task identifier must be positive and not null.");
        }
        if (update == null) {
            throw new IllegalArgumentException("The update data cannot be null.");
        }
        try {
            Optional<TaskEntity> existingEntity = taskRepository.findById(id);
            if (existingEntity.isPresent()) {
                TaskEntity taskToUpdate = existingEntity.get();
                if (update.getTitle() != null) {
                    taskToUpdate.setTitle(update.getTitle());
                }
                if (update.getContent() != null) {
                    taskToUpdate.setContent(update.getContent());
                }
                TaskEntity updatedEntity = taskRepository.save(taskToUpdate);
                return mapper.entityToModel(updatedEntity);
            } else {
                throw new TaskNotFoundException("Task not found for id: " + id);
            }
        } catch (DataAccessException dae) {
            log.error("Data access error while updating task with id: " + id, dae);
            throw dae;
        }
    }

    // DELETE

    /**
     * Method used to delete all task.
     * @return HttpStatus object 
     * @throws NoTasksFoundException if no tasks are found.
     * @throws DataAccessException if there is an error accessing the database.
     */ 
    @Override
    public void deleteAllTasks() {
        try {
            long count = taskRepository.count();
            if (count == 0) {
                throw new NoTasksFoundException("No tasks available to delete.");
            }
            taskRepository.deleteAll();
            log.info("All tasks have been successfully deleted.");
        } catch (DataAccessException dae) {
            log.error("Data access error while trying to delete all tasks.", dae);
            throw dae;
        }
    } 

    /**
     * Method used to delete a task by its id.
     * @param id Identification
     * @return HttpStatus object
     * @throws IllegalArgumentException if the id is null or non-positive.
     * @throws TaskNotFoundException if the task with the specified id is not found.
     * @throws DataAccessException if there is an error accessing the database.
     */ 
    @Override
    public void deleteTaskById(Long id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException("The task identifier must be positive and not null.");
        }
        try {
            Optional<TaskEntity> existingTask = taskRepository.findById(id);
            if (existingTask.isPresent()) {
                taskRepository.deleteById(id);
                log.info("Task with id " + id + " has been successfully deleted.");
            } else {
                throw new TaskNotFoundException("Task not found for id: " + id);
            }
        } catch (DataAccessException dae) {
            log.error("Data access error while trying to delete task with id: " + id, dae);
            throw dae;
        }
    }
}
