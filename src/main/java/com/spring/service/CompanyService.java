package com.spring.service;

import com.spring.database.CompanyRepository;
import com.spring.database.UserRepository;

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
