package com.back.to_do_list_back.service;

import com.back.to_do_list_back.entity.TaskEntity;
import com.back.to_do_list_back.mapper.TaskMapper;
import com.back.to_do_list_back.model.TaskModel;
import com.back.to_do_list_back.repository.TaskRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class TaskServiceImpl implements TaskService {
    
    private TaskRepository taskRepository; 

    private TaskMapper mapper;

    /**
     * Method used to create a task.
     * @param model Model object
     * @return Model object
     */
    @Override
    public TaskModel createATask(TaskModel model) {
        log.debug("Model: " + model.toString());

        TaskEntity entity = mapper.modelToEntity(model);

        log.debug("Entity: " + entity.toString());

        TaskEntity save = taskRepository.save(entity);

        return mapper.entityToModel(save);
    } 

    /**
     * Method used to display all tasks.
     * @return Model object
     */
    @Override
    public List<TaskModel> displayAllTasks() { 

        List<TaskEntity> taskEntities = taskRepository.findAll(); 
        
        return mapper.listEntityToListModel(taskEntities);
    }
}
