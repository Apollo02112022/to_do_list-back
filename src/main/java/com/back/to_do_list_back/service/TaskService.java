package com.back.to_do_list_back.service;

import com.back.to_do_list_back.model.TaskModel;
import com.back.to_do_list_back.model.TaskUpdateModel;

import java.util.List;

/**
 * Interface TaskService implemented
 * by the TaskServiceImp class.
 */
public interface TaskService {

    // CREATE 
    
    /**
     * Signature of a create method to create a task.
     * @param model Model object
     * @return Model object
     */
    TaskModel createATask(TaskModel model); 

    // READ 

    /**
     * Signature of a display method to display all tasks.
     * @return  List<TaskEntity> Collection
     */
    List<TaskModel> displayAllTasks(); 

    /**
     * Signature of a displayTaskById method to display a task according to its id.
     * @param id Identification
     * @return Model object
     */ 
    TaskModel displayTaskById(Long id);

    // UPDATE 

    /**
     * Signature of an updateTask method to update a task according to its id.
     * @param id Identification
     * @return Model object
     */
    TaskModel updateTask(Long id, TaskUpdateModel update);

    // DELETE 

    /**
     * Signature of a deleteAllTasks method to delete all tasks.
     * @return HttpStatus object
     */ 
    void deleteAllTasks(); 

    /**
     * Signature of a deleteTaskById method to delete a task according to its id.
     * @param id Identification
     * @return HttpStatus object
     */ 
    void deleteTaskById(Long id);
}
