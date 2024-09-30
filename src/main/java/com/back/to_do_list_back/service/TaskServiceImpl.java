package com.back.to_do_list_back.service;

import com.back.to_do_list_back.entity.TaskEntity;
import com.back.to_do_list_back.mapper.TaskMapper;
import com.back.to_do_list_back.model.TaskModel;
import com.back.to_do_list_back.repository.TaskRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class TaskServiceImpl implements TaskService {
    
    private TaskRepository taskRepository; 

    private TaskMapper mapper;

    /**
     * Method used to create a task.
     * @param model Model object
     * @return Model object
     */
    @Override
    public TaskModel create(TaskModel model) {
        log.debug("Model: " + model.toString());

        TaskEntity entity = mapper.modelToEntity(model);

        log.debug("Entity: " + entity.toString());

        TaskEntity save = taskRepository.save(entity);

        return mapper.entityToModel(save);
    } 
}
