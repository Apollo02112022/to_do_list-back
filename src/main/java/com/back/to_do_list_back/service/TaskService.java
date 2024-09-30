package com.back.to_do_list_back.service;

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
    TaskModel create(TaskModel model); 
}
