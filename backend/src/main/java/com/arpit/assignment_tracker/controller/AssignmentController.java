package com.arpit.assignment_tracker.controller;

import com.arpit.assignment_tracker.entity.Assignment;

import com.arpit.assignment_tracker.service.AssignmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    @Autowired
    private AssignmentService assignmentService;

    @PostMapping("/create")
    public Assignment createAssignment(@RequestBody Assignment assignment){
        return assignmentService.createAssignment(assignment);
    }
}
