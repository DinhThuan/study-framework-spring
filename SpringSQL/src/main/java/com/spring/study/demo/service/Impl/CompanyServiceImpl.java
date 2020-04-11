package com.spring.study.demo.service.Impl;

import com.spring.study.demo.constants.Constant;
import com.spring.study.demo.entities.Company;
import com.spring.study.demo.model.ServiceResult;
import com.spring.study.demo.repository.CompanyRepository;
import com.spring.study.demo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyServiceImpl implements CompanyService {
    @Autowired
    public CompanyRepository companyRepository;

    @Override
    public ServiceResult getListCompany() {
        ServiceResult serviceResult = new ServiceResult();
        serviceResult.setData(companyRepository.findAll());
        serviceResult.setCode(Constant.CODE_SUCCESS);
        return serviceResult;
    }

    @Override
    public ServiceResult findCompanyById(int id) {
        ServiceResult serviceResult = new ServiceResult();
        Company company = companyRepository.findById(id).orElse(null);
        if (company == null) {
            serviceResult.setCode(Constant.CODE_FAIL);
            serviceResult.setMessage(Constant.MESSAGE_FAIL);
        } else {
            serviceResult.setData(company);
            serviceResult.setCode(Constant.CODE_SUCCESS);
            serviceResult.setMessage(Constant.MESSAGE_SUCCESS);
        }

        return serviceResult;
    }

    @Override
    public ServiceResult createNewCompany(Company company) {
        ServiceResult serviceResult = new ServiceResult();
        companyRepository.save(company);
        System.out.println("Save entities: " + companyRepository.save(company));
        return serviceResult;
    }

    @Override
    public ServiceResult updateCompany(Company company) {
        ServiceResult serviceResult = new ServiceResult();
        if(!companyRepository.findById(company.getId()).isPresent()){
            serviceResult.setCode(Constant.CODE_FAIL);
        }else{
            serviceResult.setData(companyRepository.save(company));
            serviceResult.setCode(Constant.CODE_SUCCESS);
            serviceResult.setMessage(Constant.MESSAGE_UPDATE_SUCCESS);
        }
        return serviceResult;
    }

    @Override
    public ServiceResult deleteCompanyById(int id) {
        ServiceResult serviceResult = new ServiceResult();
        Company company = companyRepository.findById(id).orElse(null);
        if (company == null) {
            serviceResult.setCode(Constant.CODE_FAIL);
            serviceResult.setMessage(Constant.MESSAGE_DELETE_FAIL);
        } else {
            companyRepository.delete(company);
            serviceResult.setCode(Constant.CODE_SUCCESS);
            serviceResult.setMessage(Constant.MESSAGE_DELETE_SUCCESS);
        }
        return serviceResult;
    }
}
