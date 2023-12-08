package com.example.employeecrudapplication.service;

import com.example.employeecrudapplication.model.Employee;
import com.example.employeecrudapplication.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
  @Autowired
  private EmployeeRepository employeeRepository;

  public String createEmployee(Employee employee) {
    employeeRepository.save(employee);
    return "New Employee Added.";
  }

  public List<Employee> getAllEmployees() {
    return employeeRepository.findAll();
  }

  public Employee getEmployeeById(long id) {
    return employeeRepository.findById(id).orElseGet(() -> null);
  }

  public String updateEmployee(long id, Employee employee) {
    Employee updatedEmployee = employeeRepository.findById(id).get();
    updatedEmployee.setFirstName(employee.getFirstName());
    updatedEmployee.setLastName(employee.getLastName());
    updatedEmployee.setEmail(employee.getEmail());
    updatedEmployee.setPhone(employee.getPhone());
    updatedEmployee.setTitle(employee.getTitle());
    updatedEmployee.setDepartment(employee.getDepartment());
    employeeRepository.save(updatedEmployee);
    return "Updated Employee Details.";
  }

  public String deleteEmployee(long id) {
    Employee deleteEmployee = employeeRepository.findById(id).get();
    employeeRepository.delete(deleteEmployee);
    return "Deleted Employee with the ID: " + id;
  }

}
