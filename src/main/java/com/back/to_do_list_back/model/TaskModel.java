package com.back.to_do_list_back.model;

import java.time.LocalDateTime;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor; 

/**
 * Model used to create a task.
 */
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class TaskModel {
   
    private Long id;

    @NonNull
    private String title; 

    @NonNull
    private String content; 

    @NonNull
    private Boolean isCompleted = false;

    private LocalDateTime completionTime;

    @NonNull
    private LocalDateTime createdAt = LocalDateTime.now();
}
