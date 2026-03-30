package com.arpit.assignment_tracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "assignments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "assignment")
    @JsonIgnore
    private List<Submission> submissions;

    private String title;

    @Column(columnDefinition = "TEXT")  // important for long questions
    private String task;

    private LocalDateTime deadline;

    private Long createdBy;
}