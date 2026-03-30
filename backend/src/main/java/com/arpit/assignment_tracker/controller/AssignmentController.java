package com.arpit.assignment_tracker.controller;

import com.arpit.assignment_tracker.dto.AssignmentDTO;
import com.arpit.assignment_tracker.entity.Assignment;

import com.arpit.assignment_tracker.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/create")
    public Assignment createAssignment(@RequestBody Assignment assignment){
        return assignmentService.createAssignment(assignment);
    }

    @GetMapping
    public List<AssignmentDTO> getAllAssignments() {
        List<Assignment> assignments = assignmentService.findAllAssignments();

        return assignments.stream().map(a ->
                new AssignmentDTO(
                        a.getId(),
                        a.getTitle(),
                        a.getTask(),
                        a.getUser() != null ? a.getUser().getName() : "No User"
                )
        ).toList();
    }
}
