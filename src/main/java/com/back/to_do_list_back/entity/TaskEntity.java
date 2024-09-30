package com.back.to_do_list_back.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime; 
import lombok.Data;

@Entity
@Data
@Table(name = "tasks")
public class TaskEntity {

    // Unique identifier for each task.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Task title.
    @Column(nullable = false, length = 255)
    private String title;

    // Task content.
    @Column(nullable = false)
    private String content;

    // Indicates task completion.
    @Column(nullable = false)
    private Boolean isCompleted = false;

    // Date and time of completion (NULL if not completed).
    private LocalDateTime completionTime;

    // Task creation date and time.
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    // Getters and setters
}
