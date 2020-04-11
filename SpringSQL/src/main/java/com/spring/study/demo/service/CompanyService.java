package com.spring.study.demo.service;

import com.spring.study.demo.entities.Company;
import com.spring.study.demo.model.ServiceResult;

public interface CompanyService {
    public ServiceResult getListCompany();

    public ServiceResult findCompanyById(int id);

    public ServiceResult createNewCompany(Company company);

    public ServiceResult updateCompany(Company company);

    public ServiceResult deleteCompanyById(int id);
}
