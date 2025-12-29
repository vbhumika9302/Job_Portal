package com.jobportal.entity;

import lombok.*;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "activity_logs")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ActivityLog {
    @Id 
    private String id;

    private String action; // e.g., "USER_REGISTERED", "JOB_POSTED", "APPLICATION_SUBMITTED"
    private String entityType; // USER, JOB, APPLICATION
    private Long entityId;

    private String performedBy; // user email or id string

    @Column(length = 2000)
    private String details;

    private LocalDateTime createdAt;
//
//    @PrePersist
//    public void prePersist() { createdAt = Instant.now(); }
}
