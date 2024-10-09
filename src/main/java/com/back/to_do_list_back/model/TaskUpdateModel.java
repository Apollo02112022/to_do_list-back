package com.back.to_do_list_back.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull; 

import org.hibernate.validator.constraints.Length;

/**
 * Update Model used in the case of a complete
 * or partial upgrade of a task.
 */
@Data
public class TaskUpdateModel {

    @Size(min = 1, max = 50, message = "The title must be between {min} and {max} characters long.")
    @Schema(example = "Title of my task.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String title; 

    @Length(min = 1, max = 250, message = "The content must be between {min} and {max} characters long.")
    @Schema(example = "Content of my task.", requiredMode = Schema.RequiredMode.REQUIRED)
    private String content; 
}
