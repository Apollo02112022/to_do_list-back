package com.back.to_do_list_back.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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

    // Task creation date and time.
    @Column(nullable = false)
    private LocalDate createdAt = LocalDate.now();

    // Getters and setters
}
