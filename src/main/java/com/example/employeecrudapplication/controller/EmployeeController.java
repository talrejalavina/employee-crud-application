package com.example.employeecrudapplication.controller;

import com.example.employeecrudapplication.model.Employee;
import com.example.employeecrudapplication.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

}
