package com.jobportal.controller;

import com.jobportal.dto.EmployeeCreateDTO;
import com.jobportal.dto.LoginRequestDTO;
import com.jobportal.dto.LoginResponseDTO;
import com.jobportal.entity.Employee;
import com.jobportal.service.EmployeeService;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/v1.0/createEmployee")
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody EmployeeCreateDTO dto) {
        return ResponseEntity.ok(employeeService.saveEmployee(dto));
    }

    @GetMapping("/v1.0/getEmployeeById/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable String employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @GetMapping("/v1.0/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @PutMapping("/v1.0/updateEmployeeById/{employeeId}")
    public ResponseEntity<Employee> updateEmployee(
            @PathVariable String employeeId,
            @Valid @RequestBody EmployeeCreateDTO dto) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId, dto));
    }

    @DeleteMapping("/v1.0/deleteEmployeeById/{employeeId}")
    public ResponseEntity<String> deleteEmployee(@PathVariable String employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully.");
    }
    @PostMapping("/v1.0/login")
    public ResponseEntity<LoginResponseDTO> login(
            @Valid @RequestBody LoginRequestDTO dto) {
        return ResponseEntity.ok(employeeService.login(dto));
    }
    @GetMapping("/test")
    public String test() {
        return "Employee controller working";
    }
}
