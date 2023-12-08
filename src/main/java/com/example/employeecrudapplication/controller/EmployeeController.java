package com.example.employeecrudapplication.controller;

import com.example.employeecrudapplication.model.Employee;
import com.example.employeecrudapplication.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class EmployeeController {

  @Autowired
  private EmployeeRepository employeeRepository;

  @GetMapping(value = "/")
  public String getPage() {
    return "Welcome everyone!";
  }

  @PostMapping(value = "/save")
  public String createEmployee(@RequestBody Employee employee) {
    employeeRepository.save(employee);
    return "New Employee Added.";
  }

  @GetMapping(value = "/employees")
  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  @GetMapping("/{id}")
  public Employee getEmployeeById(@PathVariable Long id) {
    return employeeRepository.findById(id).orElseGet(() -> null);
  }

}
