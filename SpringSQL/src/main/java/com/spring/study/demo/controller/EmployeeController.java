package com.spring.study.demo.controller;

import com.spring.study.demo.entities.Employee;
import com.spring.study.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "employee")
public class EmployeeController {
    @Autowired
    public EmployeeService employeeService;

    @GetMapping("/list")
    public ResponseEntity<List<Employee>> findAllEmployee() {
        return new ResponseEntity<List<Employee>>(employeeService.getListEmployee(), HttpStatus.OK);
    }

    

}
