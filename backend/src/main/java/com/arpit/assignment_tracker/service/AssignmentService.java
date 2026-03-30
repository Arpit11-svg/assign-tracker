package com.arpit.assignment_tracker.service;

import com.arpit.assignment_tracker.entity.Assignment;
import com.arpit.assignment_tracker.repository.AssignmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssignmentService {

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Assignment createAssignment(Assignment assignment) {
        return assignmentRepository.save(assignment);
    }

    public List<Assignment> findAllAssignments(){
        return assignmentRepository.findAll();
    }

}
