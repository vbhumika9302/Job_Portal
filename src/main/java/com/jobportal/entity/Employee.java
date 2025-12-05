package com.jobportal.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String gender;
    private LocalDate dob;
    private Integer age;

    @Column(unique = true)
    private String email;

    private String phoneNo;
    private String designation;

    private LocalDateTime createdAt = LocalDateTime.now();
}
