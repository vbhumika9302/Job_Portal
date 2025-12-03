package com.jobportal.entity;

import lombok.*;


import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false)
    private String title;

    @Column(length = 4000)
    private String description;

    @Column(nullable=false)
    private String location;

    private String employmentType; // FULL_TIME, CONTRACT, etc.

    private Instant postedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="posted_by")
    private User postedBy;

    @PrePersist
    public void prePersist() { postedAt = Instant.now(); }
}
