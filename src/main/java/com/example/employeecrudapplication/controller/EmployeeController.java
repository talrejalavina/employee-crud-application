package com.example.employeecrudapplication.controller;

import com.example.employeecrudapplication.model.Employee;
import com.example.employeecrudapplication.service.EmployeeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


import java.util.List;

@RestController
public class EmployeeController {

  @Autowired
  private EmployeeService employeeService;

  @GetMapping(value = "/")
  public String getPage() {
    return "Welcome everyone!";
  }

  @PostMapping(value = "/save")
  public String createEmployee(@RequestBody Employee employee) {
    return employeeService.createEmployee(employee);
  }

  @GetMapping(value = "/employees")
  public List<Employee> getAllEmployees() {
    return employeeService.getAllEmployees();
  }

  @GetMapping("/{id}")
  public Employee getEmployeeById(@PathVariable long id) {
    return employeeService.getEmployeeById(id);
  }

  @PutMapping(value = "update/{id}")
  public String updateEmployee(@PathVariable long id, @RequestBody Employee employee) {
    return employeeService.updateEmployee(id, employee);
  }

  @DeleteMapping(value = "/delete/{id}")
  public String deleteEmployee(@PathVariable long id) {
    return employeeService.deleteEmployee(id);
  }

}
