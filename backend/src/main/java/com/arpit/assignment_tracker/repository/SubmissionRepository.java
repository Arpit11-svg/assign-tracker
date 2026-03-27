package com.arpit.assignment_tracker.repository;

import com.arpit.assignment_tracker.entity.Assignment;
import com.arpit.assignment_tracker.entity.Submission;
import com.arpit.assignment_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission,Long> {
    Optional<Submission> findByUserAndAssignment(User user, Assignment assignment);

    List<Submission> findByAssignmentOrderBySubmissionTimeAsc(Assignment assignment);
}
