package com.back.to_do_list_back.controller;

import com.back.to_do_list_back.model.TaskModel;
import com.back.to_do_list_back.model.TaskUpdateModel;
import com.back.to_do_list_back.service.TaskService;
import com.back.to_do_list_back.utils.Constants;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static com.back.to_do_list_back.utils.Util.asJsonString;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@Disabled
@WebMvcTest(TaskController.class)
public class TaskControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Test
    void givenTask_whenCreate_thenReturnCode201() throws Exception {
        // Given
        TaskModel inputModel = new TaskModel();
        inputModel.setId(1L);
        inputModel.setTitle("Title");
        inputModel.setContent("Message content.");
        inputModel.setIsCompleted(false);
        inputModel.setCreatedAt(LocalDate.now());

        TaskModel simulatedModel = new TaskModel();
        simulatedModel.setId(1L);
        simulatedModel.setTitle("Title");
        simulatedModel.setContent("Message content.");
        simulatedModel.setIsCompleted(false);
        simulatedModel.setCreatedAt(LocalDate.now());

        given(taskService.createATask(inputModel)).willReturn(simulatedModel);

        // When
        ResultActions result = mockMvc.perform(post(Constants.API_TASKS)
                .content(asJsonString(inputModel))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // Then
        result.andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").value(1L))
                .andExpect(jsonPath("$.title").value("Title"))
                .andExpect(jsonPath("$.content").value("Message content."))
                .andExpect(jsonPath("$.isCompleted").value(false))
                .andExpect(jsonPath("$.createdAt").value(LocalDate.now()));

        // Verify
        verify(taskService, times(1)).createATask(inputModel);
    }

    @Test
    void givenTask_whenDisplayAll_thenReturnCode200() throws Exception {
        // Given
        List<TaskModel> simulatedTaskModels = new ArrayList<>();
        simulatedTaskModels.add(new TaskModel(1L, "Title 1", "Message content.", false, LocalDate.now()));
        simulatedTaskModels.add(new TaskModel(2L, "Title 2", "Message content.", false, LocalDate.now()));

        given(taskService.displayAllTasks()).willReturn(simulatedTaskModels);

        // When
        ResultActions result = mockMvc.perform(get(Constants.API_TASKS + "/all")
                .accept(MediaType.APPLICATION_JSON));

        // Then
        result.andExpect(status().isOk());

        // Verify
        verify(taskService, times(1)).displayAllTasks();
    }

    @Test
    void givenTask_whenDisplayById_thenReturnCode200() throws Exception {
        // Given
        Long id = 1L;

        TaskModel simulatedModel = new TaskModel();
        simulatedModel.setId(1L);
        simulatedModel.setTitle("Title");
        simulatedModel.setContent("Message content.");
        simulatedModel.setIsCompleted(false);
        simulatedModel.setCreatedAt(LocalDate.now());

        given(taskService.displayTaskById(id)).willReturn(simulatedModel);

        // When
        ResultActions result = mockMvc.perform(get(Constants.API_TASKS + "/{id}", 1L)
                .accept(MediaType.APPLICATION_JSON));

        // Then
        result.andExpect(status().isOk());

        // Verify
        verify(taskService, times(1)).displayTaskById(id);
    }

    @Test
    void givenTask_whenUpdate_thenReturnCode200() throws Exception {
        // Given
        Long id = 1L;

        TaskUpdateModel inputModel = new TaskUpdateModel();
        inputModel.setTitle("Title");
        inputModel.setContent("Message content.");

        TaskModel simulatedModel = new TaskModel();
        simulatedModel.setIsCompleted(false);
        simulatedModel.setCreatedAt(LocalDate.now());

        given(taskService.updateTask(id, inputModel)).willReturn(simulatedModel);

        // When
        ResultActions result = mockMvc.perform(put(Constants.API_TASKS + "/{id}", id)
                .content(asJsonString(inputModel))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));

        // Then
        result.andExpect(status().isOk());

        // Verify
        verify(taskService, times(1)).updateTask(id, inputModel);
    }

   @Test
   void givenTask_whenDeleteAll_thenReturnCode204() throws Exception {
       // Given
       willDoNothing().given(taskService).deleteAllTasks();

       // When
       ResultActions result = mockMvc.perform(delete(Constants.API_TASKS + "/all"));

       // Then
       result.andExpect(status().isNoContent());

       // Verify
       verify(taskService, times(1)).deleteAllTasks();
   }

   @Test
   void givenTask_whenDeleteById_thenReturnCode204() throws Exception {
       // Given
       Long id = 1L;

       willDoNothing().given(taskService).deleteTaskById(id);

       // When
       ResultActions result = mockMvc.perform(delete(Constants.API_TASKS + "/{id}", id));

       // Then
       result.andExpect(status().isNoContent());

       // Verify
       verify(taskService, times(1)).deleteTaskById(id);
   }
}
