package com.jobportal.service;

import java.util.List;

import com.jobportal.dto.EmployeeCreateDTO;
import com.jobportal.dto.LoginRequestDTO;
import com.jobportal.dto.LoginResponseDTO;
import com.jobportal.entity.Employee;

import jakarta.validation.Valid;

public interface EmployeeService {

    Employee saveEmployee(@Valid EmployeeCreateDTO dto);

    Employee getEmployeeById(String id);

    List<Employee> getAllEmployees();

    Employee updateEmployee(String id, @Valid EmployeeCreateDTO dto);

    void deleteEmployee(String id);
    
    LoginResponseDTO login(LoginRequestDTO dto);
}

