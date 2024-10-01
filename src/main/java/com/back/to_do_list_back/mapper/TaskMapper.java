package com.back.to_do_list_back.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import com.back.to_do_list_back.entity.TaskEntity;
import com.back.to_do_list_back.model.TaskModel;

@Mapper(componentModel = "spring")
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

    /**
     * Signature of a listEntityToListModel method for converting a set of entities
     * into a set of models.
     * @param entities List of entities
     * @return List of models
     */
    List<TaskModel> listEntityToListModel(List<TaskEntity> entities);

    /**
     * Signature of a listModelToListEntity method for converting a set of models
     * into a set of entities.
     * @param models List of models
     * @return List of entities
     */
    List<TaskEntity> listModelToListEntity(List<TaskModel> models);
}
