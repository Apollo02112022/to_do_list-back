package com.back.to_do_list_back.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;

// import java.time.LocalDateTime;

import lombok.NonNull;
import lombok.RequiredArgsConstructor; 

/**
 * Model used to create a task.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TaskModel {
   
    /**
     * Field id.
     */
    private Long id;

    /**
     * Field task title.
     */
    @NonNull
    private String title; 

    /**
     * Field task content.
     */
    @NonNull
    private String content; 

    //
    @NonNull
    private Boolean isCompleted = false;

    //
    private LocalDateTime completionTime;

    //
    @NonNull
    private LocalDateTime createdAt = LocalDateTime.now();
}
