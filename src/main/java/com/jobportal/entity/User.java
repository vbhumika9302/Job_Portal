package com.jobportal.entity;

import java.time.Instant;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, unique=true)
	private String email;
	
	@Column(nullable=false)
	private String fullName;
	
	private String phoneno;
	
	@Column(nullable=false)
	private String role;
	
	private String resumeUrl;
	
	private Instant createdAt;
	
	@PrePersist
	public void prePersist() {createdAt = Instant.now();}
	
	

}
