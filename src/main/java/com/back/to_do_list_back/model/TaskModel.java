package com.back.to_do_list_back.model;

import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.*;

import org.hibernate.validator.constraints.Length;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Model used to create a task.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TaskModel {
   
    private Long id;

    @NonNull
    @NotBlank(message = "The title attribute is mandatory.")
    @Size(min = 1, max = 50, message = "The title must be between {min} and {max} characters long.")
    @Schema(example = "Title of my task.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title; 

    @NonNull
    @NotBlank(message = "The content attribute is mandatory.")
    @Length(min = 1, max = 250, message = "The content must be between {min} and {max} characters long.")
    @Schema(example = "Content of my task.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content;

    @Schema(description = "Indicates whether the task is completed or not.", example = "false", defaultValue = "false")
    private Boolean isCompleted = false;

    @Schema(description = "Date the task was created.", example = "YYYY/MM/DD")
    private LocalDate createdAt = LocalDate.now();
}
