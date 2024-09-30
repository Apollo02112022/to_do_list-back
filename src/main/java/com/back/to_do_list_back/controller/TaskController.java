package com.back.to_do_list_back.controller;

import com.back.to_do_list_back.model.TaskModel;
import com.back.to_do_list_back.service.TaskService; 
import com.back.to_do_list_back.utils.Constants;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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

            return ResponseEntity.status(HttpStatus.CREATED).body(taskService.create(model));

        } catch (Exception ex) {
            log.error("Error occurred while creating task: " + ex.getMessage(), ex);

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }

    // READ 

    // UPDATE 

    // DELETE 
}
