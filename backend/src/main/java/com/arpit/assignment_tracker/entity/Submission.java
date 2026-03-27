package com.arpit.assignment_tracker.entity;

import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(
        uniqueConstraints = @UniqueConstraint(columnNames = {"user_id", "assignment_id"})
)
public class Submission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // MANY submissions by ONE user
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // MANY submissions for → ONE assignment
    @ManyToOne
    @JoinColumn(name = "assignment_id")
    private Assignment assignment;

    // content submitted by student
    private String content;

    private LocalDateTime submissionTime;

    @Enumerated(EnumType.STRING)
    private SubmissionStatus status;
}