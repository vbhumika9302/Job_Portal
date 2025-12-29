package com.jobportal.entity;

import lombok.*;

import jakarta.persistence.*;

import java.time.Instant;
import java.time.LocalDateTime;

@Entity
@Table(name = "applications", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"job_id","applicant_id"})
})
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Application {
    @Id 
    private String id;

    @ManyToOne(optional=false)
    @JoinColumn(name="job_id")
    private Job job;

    @ManyToOne(optional=false)
    @JoinColumn(name="applicant_id")
    private Employee applicant;

    @Column(nullable=false)
    private String status; // APPLIED, REVIEWED, REJECTED, HIRED

    private String coverLetter;

    private LocalDateTime appliedAt;

//    @PrePersist
//    public void prePersist() { appliedAt = Instant.now(); }
}
