package com.back.to_do_list_back.model;

import lombok.Data;
import lombok.NonNull;

/**
 * Update Model used in the case of a complete
 * or partial upgrade of a task.
 */
@Data
public class TaskUpdateModel {
    
    @NonNull
    private String title; 

    @NonNull
    private String content; 
}
