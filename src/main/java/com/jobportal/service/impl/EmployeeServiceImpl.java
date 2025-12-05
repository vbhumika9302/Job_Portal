package com.jobportal.service.impl;

import com.jobportal.entity.*;
import com.jobportal.repository.EmployeeRepository;
import com.jobportal.service.EmployeeService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employeeData) {
        return employeeRepository.findById(id).map(employee -> {
            employee.setName(employeeData.getName());
            employee.setGender(employeeData.getGender());
            employee.setDob(employeeData.getDob());
            employee.setAge(employeeData.getAge());
            employee.setEmail(employeeData.getEmail());
            employee.setPhoneNo(employeeData.getPhoneNo());
            employee.setDesignation(employeeData.getDesignation());
            return employeeRepository.save(employee);
        }).orElse(null);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}
