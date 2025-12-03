package com.jobportal.entity;

import lombok.*;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
@Table(name = "activity_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityLog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String action; // e.g., "USER_REGISTERED", "JOB_POSTED", "APPLICATION_SUBMITTED"
    private String entityType; // USER, JOB, APPLICATION
    private Long entityId;

    private String performedBy; // user email or id string

    @Column(length = 2000)
    private String details;

    private Instant createdAt;

    @PrePersist
    public void prePersist() { createdAt = Instant.now(); }
}
