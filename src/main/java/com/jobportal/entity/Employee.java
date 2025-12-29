package com.jobportal.entity;

//import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UuidGenerator;

import com.jobportal.enums.Role;

//import com.jobportal.dto.EmployeeCreateDTO;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Data
@Table(name="emp")
public class Employee {

    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(length = 36, updatable = false, nullable = false)
    private String id;

    private String name;
    private String gender;
    private LocalDate dob;
    private Integer age;

    @Column(unique = true)
    private String email;

    private String phoneNo;
    private String designation;
    
    @Column(nullable = false)
    private String password; // 🔐 HASHED PASSWORD

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;
}
