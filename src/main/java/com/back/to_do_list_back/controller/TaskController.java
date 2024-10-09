package com.back.to_do_list_back.controller;

import com.back.to_do_list_back.model.TaskModel;
import com.back.to_do_list_back.model.TaskUpdateModel;
import com.back.to_do_list_back.service.TaskService;
import com.back.to_do_list_back.utils.Constants;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.time.ZoneId;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Tag(name = "Task API", description = "API to manage tasks.")
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(Constants.API_TASKS)
@AllArgsConstructor
@Slf4j
public class TaskController {

    private TaskService taskService;

    // CREATE

    /**
     * Endpoint to create a task.
     * @return TaskModel object
     */
    @Operation(summary = "Create a new task.", description = "Request to create a new task.")
    @ApiResponse(responseCode = "201", description = "Created", content = {@Content(schema = @Schema(implementation = TaskModel.class)) })
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PostMapping
    public ResponseEntity<TaskModel> createATask(@RequestBody TaskModel model) {
        TaskModel createdTask = taskService.createATask(model);
        return new ResponseEntity<>(createdTask, HttpStatus.CREATED);
    }

    // READ

    /**
     * Endpoint to display all tasks.
     * @return List<TaskModel> Collection.
     */
    @Operation(summary = "Retrieve all task.", description = "Request to retrieve all tasks")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "204", description = "No Content")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/all")
    public ResponseEntity<List<TaskModel>> displayAllTasks() {
        List<TaskModel> tasks = taskService.displayAllTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    /**
     * Endpoint to display a task by its ID.
     * @param id Identification of the task.
     * @return TaskModel object.
     */
    @Operation(summary = "Display a task.", description = "Request to display a task by its id.")
    @ApiResponse(responseCode = "200", description = "OK")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @GetMapping("/{id}")
    public ResponseEntity<TaskModel> displayTaskById(@PathVariable Long id) {
        TaskModel task = taskService.displayTaskById(id);
        return new ResponseEntity<>(task, HttpStatus.OK);
    }

    // UPDATE

    /**
     * Endpoint to update a task by its ID.
     * @param id Identification of the task.
     * @return TaskModel object.
     */
    @Operation(summary = "Update a task.", description = "Request to update a task by its id.")
    @ApiResponse(responseCode = "200", description = "Task updated successfully!")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @PutMapping("/{id}")
    public ResponseEntity<TaskModel> updateTask(@PathVariable Long id, @RequestBody TaskUpdateModel update) {
        TaskModel updatedTask = taskService.updateTask(id, update);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    // DELETE

    /**
     * Endpoint to delete all tasks.
     * @return HttpStatus object
     */
    @Operation(summary = "Delete all tasks.", description = "Request to delete all tasks.")
    @ApiResponse(responseCode = "204", description = "No Content")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllTasks() {
        taskService.deleteAllTasks();
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    /**
     * Endpoint to delete a task by its ID.
     * @return HttpStatus object
     */ 
    @Operation(summary = "Delete a task.", description = "Request to delete a task by its id.")
    @ApiResponse(responseCode = "204", description = "No Content")
    @ApiResponse(responseCode = "400", description = "Bad Request")
    @ApiResponse(responseCode = "404", description = "Not Found")
    @ApiResponse(responseCode = "500", description = "Internal Server Error")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTaskById(@PathVariable Long id) {
        taskService.deleteTaskById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
