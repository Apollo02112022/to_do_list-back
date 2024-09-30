package com.back.to_do_list_back.model;

import java.time.LocalDateTime;

import org.antlr.v4.runtime.misc.NotNull;

// import jakarta.validation.constraints.NotBlank;

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
    // @Schema(example="1", requiredMode = Schema.RequiredMode.NOT_REQUIRED)
    private Long id;

    /**
     * Field task title.
     */
    @NonNull
    // @NotBlank(message = "The title attribute is mandatory.")
    // @Schema(example="Title", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title; 

    /**
     * Field task content.
     */
    @NonNull
    // @NotBlank(message = "The content attribute is mandatory.")
    // @Schema(example="Lorem ipsum.", requiredMode = Schema.RequiredMode.REQUIRED)
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
