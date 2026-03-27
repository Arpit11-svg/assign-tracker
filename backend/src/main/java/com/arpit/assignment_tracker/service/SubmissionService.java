package com.arpit.assignment_tracker.service;

import com.arpit.assignment_tracker.entity.Assignment;
import com.arpit.assignment_tracker.entity.Submission;
import com.arpit.assignment_tracker.entity.SubmissionStatus;
import com.arpit.assignment_tracker.entity.User;
import com.arpit.assignment_tracker.repository.AssignmentRepository;
import com.arpit.assignment_tracker.repository.SubmissionRepository;
import com.arpit.assignment_tracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class SubmissionService {

    @Autowired
    private SubmissionRepository submissionRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AssignmentRepository assignmentRepository;

    public Submission submit(Long userId, Long assignmentId, String content) {

        User user=userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Assignment assignment=assignmentRepository.findById(assignmentId).orElseThrow(() -> new RuntimeException("Assignment not found"));

        Optional<Submission> existing=submissionRepository.findByUserAndAssignment(user,assignment);

        Submission submission;
        if(existing.isPresent()){
            submission=existing.get();
        }
        else{
            submission=new Submission();
            submission.setUser(user);
            submission.setAssignment(assignment);
        }
        submission.setContent(content);

        LocalDateTime now=LocalDateTime.now();
        submission.setSubmissionTime(now);

        if(now.isBefore(assignment.getDeadline())){
            submission.setStatus(SubmissionStatus.ON_TIME);
        }
        else{
            submission.setStatus(SubmissionStatus.LATE);
        }
        submission.setSubmissionTime(LocalDateTime.now());
        return submissionRepository.save(submission);
    }

    public List<Submission> getLeaderboard(Long assignmentId) {

        Assignment assignment=assignmentRepository.findById(assignmentId).orElseThrow(()->new RuntimeException("Assignment not found"));

        return submissionRepository.findByAssignmentOrderBySubmissionTimeAsc(assignment);
    }
}
