package com.ilya.spring.service;

import com.ilya.spring.database.CompanyRepository;
import com.ilya.spring.database.UserRepository;

public class UserService {
    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;
    public UserService(UserRepository userRepository, CompanyRepository companyRepository){
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
