package com.jobportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jobportal.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
