package com.arpit.assignment_tracker.controller;


import com.arpit.assignment_tracker.entity.Submission;
import com.arpit.assignment_tracker.service.SubmissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/submission")
public class SubmissionController {

    @Autowired
    private SubmissionService submissionService;

    @PostMapping("submit")
    public Submission submit(
            @RequestParam Long userId,
            @RequestParam Long assignmentId,
            @RequestParam String content
    ){
        return submissionService.submit(userId,assignmentId,content);
    }

    @GetMapping("/leaderboard/{assignmentId}")
    public List<Submission> getLeaderboard(@PathVariable Long assignmentId){
        return submissionService.getLeaderboard(assignmentId);
    }
}
