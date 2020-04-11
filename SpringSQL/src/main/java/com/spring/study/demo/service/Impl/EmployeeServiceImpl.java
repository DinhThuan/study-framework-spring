package com.spring.study.demo.service.Impl;

import com.spring.study.demo.entities.Employee;
import com.spring.study.demo.repository.EmployeeRepository;
import com.spring.study.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    public EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getListEmployee() {
        return employeeRepository.findAll();
    }
}
