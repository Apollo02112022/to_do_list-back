package com.back.to_do_list_back.service;

import java.util.List;

import com.back.to_do_list_back.model.TaskModel;

/**
 * Interface TaskService implemented
 * by the TaskServiceImp class.
 */
public interface TaskService {
    
    /**
     * Signature of a create method to create a task.
     * @param model Model object
     * @return Model object
     */
    TaskModel createATask(TaskModel model); 

    /**
     * Signature of a display method to display all tasks.
     * @return  List<TaskEntity> Collection
     */
    List<TaskModel> displayAllTasks();
}
