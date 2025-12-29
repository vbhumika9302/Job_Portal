package com.jobportal.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.jobportal.dto.EmployeeCreateDTO;
import com.jobportal.dto.LoginRequestDTO;
import com.jobportal.dto.LoginResponseDTO;
import com.jobportal.entity.Employee;
import com.jobportal.repository.EmployeeRepository;
import com.jobportal.service.EmployeeService;
import com.jobportal.util.PasswordUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // ================= CREATE EMPLOYEE =================
    @Override
    public Employee saveEmployee(EmployeeCreateDTO dto) {

        Employee emp = new Employee();
        emp.setName(dto.getName());
        emp.setGender(dto.getGender());
        emp.setDob(dto.getDob());
        emp.setAge(dto.getAge());
        emp.setEmail(dto.getEmail());
        emp.setPhoneNo(dto.getPhoneNo());
        emp.setDesignation(dto.getDesignation());
        emp.setPassword(PasswordUtil.encode(dto.getPassword()));
        emp.setRole(dto.getRole());

        return employeeRepository.save(emp);
    }

    // ================= GET EMPLOYEE BY ID =================
    @Override
    public Employee getEmployeeById(String id) {
        return employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + id));
    }

    // ================= GET ALL EMPLOYEES =================
    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // ================= UPDATE EMPLOYEE =================
    @Override
    public Employee updateEmployee(String id, EmployeeCreateDTO dto) {

        Employee emp = employeeRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Employee not found with id: " + id));

        emp.setName(dto.getName());
        emp.setGender(dto.getGender());
        emp.setDob(dto.getDob());
        emp.setAge(dto.getAge());
        emp.setEmail(dto.getEmail());
        emp.setPhoneNo(dto.getPhoneNo());
        emp.setDesignation(dto.getDesignation());
        emp.setRole(dto.getRole());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            emp.setPassword(PasswordUtil.encode(dto.getPassword()));
        }

        return employeeRepository.save(emp);
    }

    // ================= DELETE EMPLOYEE =================
    @Override
    public void deleteEmployee(String id) {
        if (!employeeRepository.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }
        employeeRepository.deleteById(id);
    }

    // ================= LOGIN =================
    @Override
    public LoginResponseDTO login(LoginRequestDTO dto) {

        Employee emp = employeeRepository.findByEmail(dto.getEmail())
                .orElseThrow(() -> new RuntimeException("Invalid email"));

        if (!emp.getRole().equals(dto.getRole())) {
            throw new RuntimeException("Invalid role");
        }

        if (!PasswordUtil.matches(dto.getPassword(), emp.getPassword())) {
            throw new RuntimeException("Invalid password");
        }

        LoginResponseDTO response = new LoginResponseDTO();
        response.setEmployeeId(emp.getId());
        response.setName(emp.getName());
        response.setEmail(emp.getEmail());
        response.setRole(emp.getRole());
        response.setMessage("Login successful");

        return response;
    }
}
