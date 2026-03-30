package com.arpit.assignment_tracker.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Column(unique = true)
    private String email;

    private String role;

    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Assignment> assignments;


    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<Submission> submissions;
}
