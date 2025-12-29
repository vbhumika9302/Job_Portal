package com.jobportal.entity;

import lombok.*;


import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "jobs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Job {
    @Id 
    private String id;

    @Column(nullable=false)
    private String title;

    @Column(length = 4000)
    private String description;

    @Column(nullable=false)
    private String location;

    private String employmentType; // FULL_TIME, CONTRACT, etc.

    private LocalDateTime postedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="posted_by")
    private Employee postedBy;
//
//    @PrePersist
//    public void prePersist() { postedAt = Instant.now(); }
}
