package com.back.to_do_list_back.mapper;

import com.back.to_do_list_back.entity.TaskEntity;
import com.back.to_do_list_back.model.TaskModel;

public interface TaskMapper {
    
    /**
     * Signature of a entityToModel method used to convert an entity into a model.
     * @param entity Entity object
     * @return Model object
     */
    TaskModel entityToModel(TaskEntity entity);

    /**
     * Signature of a modelToEntity method used to convert a model into an entity.
     * @param model Model object
     * return Entity object
     */
    TaskEntity modelToEntity(TaskModel model);
}
