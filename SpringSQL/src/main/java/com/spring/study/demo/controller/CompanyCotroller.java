package com.spring.study.demo.controller;

import com.spring.study.demo.entities.Company;
import com.spring.study.demo.model.ServiceResult;
import com.spring.study.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/company")
public class CompanyCotroller {
    @Autowired
    public CompanyService companyService;

    @GetMapping(value = "/list")
    public ResponseEntity<ServiceResult> getListCompany() {
        return new ResponseEntity<ServiceResult>(companyService.getListCompany(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServiceResult> getCompanyById(@PathVariable int id) {
        return new ResponseEntity<ServiceResult>(companyService.findCompanyById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<ServiceResult> createCompany(@RequestBody Company company) {
        return new ResponseEntity<>(companyService.createNewCompany(company), HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<ServiceResult> deleteCompanyById(@RequestBody Company company){
        System.out.println("ID delete: "+company);
        return new ResponseEntity<>(companyService.deleteCompanyById(company.getId()), HttpStatus.OK);
    }

}
