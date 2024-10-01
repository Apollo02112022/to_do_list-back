package com.back.to_do_list_back.controller;

import com.back.to_do_list_back.entity.TaskEntity;
import com.back.to_do_list_back.model.TaskModel;
import com.back.to_do_list_back.service.TaskService;
import com.back.to_do_list_back.utils.Constants;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(Constants.API_TASKS)
@AllArgsConstructor
@Slf4j
public class TaskController {

    private TaskService taskService;

    // CREATE

    @PostMapping
    public ResponseEntity<Object> create(@RequestBody TaskModel model) {
        try {
            log.debug("Entered in the create method.");

            return ResponseEntity.status(HttpStatus.CREATED).body(taskService.createATask(model));

        } catch (Exception ex) {
            log.error("Error occurred while creating task: " + ex.getMessage(), ex);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    // READ

    @GetMapping("/all")
    public ResponseEntity<Object> displayAllTasks() throws Exception {
        try {
            List<TaskModel> tasks = taskService.displayAllTasks();

            if (tasks.isEmpty()) {
                log.warn("No tasks found.");
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No tasks found.");
            }

            return ResponseEntity.ok(tasks);

        } catch (IllegalArgumentException ex) {
            log.error("Error occurred: " + ex.getMessage(), ex);

            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("An error occurred: " + ex.getMessage());
            
        } catch (Exception ex) {
            log.error("Unexpected error occurred.", ex);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("An unexpected error occurred while retrieving tasks.");
        }
    }

    // UPDATE

    // DELETE
}
