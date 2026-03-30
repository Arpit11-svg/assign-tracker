package com.arpit.assignment_tracker.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AssignmentDTO {
    private Long id;
    private String title;
    private String task;
    private String userName;
}