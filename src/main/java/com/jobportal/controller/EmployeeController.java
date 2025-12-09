package com.jobportal.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jobportal.entity.Employee;
import com.jobportal.service.EmployeeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Operation(summary = "Create a new employee", description = "Creates and returns the created employee.")
    @PostMapping("/v1.0/createEmployee")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.saveEmployee(employee));
    }

    @Operation(summary = "Get employee by id", description = "Provide an employeeId to lookup specific employee")
    @GetMapping("/v1.0/getEmployeeById/{employeeId}")
    public ResponseEntity<Employee> getEmployeeById(
        @Parameter(description = "Id of the employee to be fetched", required = true)
        @PathVariable Long employeeId) {
        return ResponseEntity.ok(employeeService.getEmployeeById(employeeId));
    }

    @Operation(summary = "Get all employees", description = "Returns list of all employees")
    @GetMapping("/v1.0/getAllEmployees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.getAllEmployees());
    }

    @Operation(summary = "Update employee by id", description = "Updates employee by employeeId and returns updated record")
    @PutMapping("/v1.0/updateEmployeeById/{employeeId}")
    public ResponseEntity<Employee> updateEmployeeById(
        @PathVariable Long employeeId,
        @RequestBody Employee employee) {
        return ResponseEntity.ok(employeeService.updateEmployee(employeeId, employee));
    }

    @Operation(summary = "Delete employee by id")
    @DeleteMapping("/v1.0/deleteEmployeeById/{employeeId}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable Long employeeId) {
        employeeService.deleteEmployee(employeeId);
        return ResponseEntity.ok("Employee deleted successfully.");
    }
}