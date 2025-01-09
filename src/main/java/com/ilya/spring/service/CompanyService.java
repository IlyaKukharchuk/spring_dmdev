package com.ilya.spring.service;

import com.ilya.spring.database.UserRepository;
import com.ilya.spring.database.CompanyRepository;

public class CompanyService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    private CompanyService companyService;

    public CompanyService(UserRepository userRepository, CompanyRepository companyRepository) {
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }

    public void setCompanyService(CompanyService companyService) {
        this.companyService = companyService;
    }
}
