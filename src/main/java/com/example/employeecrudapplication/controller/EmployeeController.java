package com.example.employeecrudapplication.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

  @GetMapping(value = "/")
  public String getPage() {
    return "Welcome everyone!";
  }

}
