package com.example.employeecrudapplication.repository;

import com.example.employeecrudapplication.model.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
