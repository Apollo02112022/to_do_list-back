package com.back.to_do_list_back.mapper;

import com.back.to_do_list_back.entity.TaskEntity;
import com.back.to_do_list_back.model.TaskModel;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@Disabled
public class TaskMapperImplTest {

    private final TaskMapperImpl taskMapperImpl = new TaskMapperImpl();

    @Test
    void givenNullEntity_whenEntityToModel_thenReturnNull() {
        // Given
        TaskEntity nullEntity = null;

        // When
        TaskModel mappedModel = taskMapperImpl.entityToModel(nullEntity);

        // Then
        assertNull(mappedModel);
    }

    @Test
    void givenTask_whenEntityToModel_thenNoNullEntity() {
        // Given
        TaskEntity simulatedEntity = new TaskEntity();
        simulatedEntity.setId(1L);
        simulatedEntity.setTitle("Title");
        simulatedEntity.setContent("Message content.");
        simulatedEntity.setIsCompleted(false);
        simulatedEntity.setCreatedAt(LocalDate.now());

        TaskModel simulatedModel = new TaskModel();
        simulatedModel.setId(1L);
        simulatedModel.setTitle("Title");
        simulatedModel.setContent("Message content.");
        simulatedModel.setIsCompleted(false);
        simulatedModel.setCreatedAt(LocalDate.now());

        // When
        TaskModel mappedModel = taskMapperImpl.entityToModel(simulatedEntity);

        //  Then
        assertEquals(mappedModel, simulatedModel);
        assertEquals(1L, mappedModel.getId());
        assertEquals("Title", mappedModel.getTitle());
        assertEquals("Message content.", mappedModel.getContent());
        assertEquals(false, mappedModel.getIsCompleted());
        assertEquals(LocalDate.now(), mappedModel.getCreatedAt());
    }

    @Test
    void givenTask_whenModelToEntity_thenNullModel() {
        // Given
        TaskModel nullModel = null;

        // When
        TaskEntity mappedEntity = taskMapperImpl.modelToEntity(nullModel);

        // Then
        assertNull(mappedEntity);
    }

    @Test
    void givenTask_whenModelToEntity_thenNoNullModel() {
        // Given
        TaskModel simulatedModel = new TaskModel();
        simulatedModel.setId(1L);
        simulatedModel.setTitle("Title");
        simulatedModel.setContent("Message content.");
        simulatedModel.setIsCompleted(false);
        simulatedModel.setCreatedAt(LocalDate.now());

        TaskEntity simulatedEntity = new TaskEntity();
        simulatedEntity.setId(1L);
        simulatedEntity.setTitle("Title");
        simulatedEntity.setContent("Message content.");
        simulatedEntity.setIsCompleted(false);
        simulatedEntity.setCreatedAt(LocalDate.now());

        // When
        TaskEntity mappedEntity = taskMapperImpl.modelToEntity(simulatedModel);

        // Then
        assertEquals(mappedEntity, simulatedEntity);
        assertEquals(1L, mappedEntity.getId());
        assertEquals("Title", mappedEntity.getTitle());
        assertEquals("Message content.", mappedEntity.getContent());
        assertEquals(false, mappedEntity.getIsCompleted());
        assertEquals(LocalDate.now(), mappedEntity.getCreatedAt());
    }

    @Test
    void givenTask_whenlistEntityToListModel_thenNullEntities() {
        // Given
        List<TaskEntity> nullEntities = null;

        // When
        List<TaskModel> mappedModels = taskMapperImpl.listEntityToListModel(nullEntities);

        // Then
        assertNull(mappedModels);
    }

    @Test
    void givenTask_whenlistEntityToListModel_thenNoNullEntities() {
        // Given
        List<TaskEntity> simulatedEntities = new ArrayList<>();
        simulatedEntities.add(new TaskEntity(1L, "Title 1", "Message content.", false, LocalDate.now()));
        simulatedEntities.add(new TaskEntity(2L, "Title 2", "Message content.", false, LocalDate.now()));

        List<TaskModel> simulatedModels = new ArrayList<>();
        simulatedModels.add(new TaskModel(1L, "Title 1", "Message content.", false, LocalDate.now()));
        simulatedModels.add(new TaskModel(2L, "Title 2", "Message content.", false, LocalDate.now()));

        // When
        List<TaskModel> mappedModels = taskMapperImpl.listEntityToListModel(simulatedEntities);

        // Then
        assertEquals(simulatedModels, mappedModels);
    }

    @Test
    void givenTask_whenlistModelToListEntity_thenNullModels() {
        // Given
        List<TaskModel> nullModels = null;

        // When
        List<TaskEntity> mappedEntities = taskMapperImpl.listModelToListEntity(nullModels);

        // Then
        assertNull(mappedEntities);
    }

    @Test
    void givenTask_whenlistModelToListEntity_thenNoNullModels() {
        // Given
        List<TaskModel> simulatedModels = new ArrayList<>();
        simulatedModels.add(new TaskModel(1L, "Title 1", "Message content.", false, LocalDate.now()));
        simulatedModels.add(new TaskModel(2L, "Title 2", "Message content.", false, LocalDate.now()));

        List<TaskEntity> simulatedEntities = new ArrayList<>();
        simulatedEntities.add(new TaskEntity(1L, "Title 1", "Message content.", false, LocalDate.now()));
        simulatedEntities.add(new TaskEntity(2L, "Title 2", "Message content.", false, LocalDate.now()));

        // When
        List<TaskEntity> mappedEntities = taskMapperImpl.listModelToListEntity(simulatedModels);

        // Then
        assertEquals(simulatedEntities, mappedEntities);
    }
}
