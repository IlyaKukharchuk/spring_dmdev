package com.ilya.spring.service;

import com.ilya.spring.database.UserRepository;
import com.ilya.spring.database.CompanyRepository;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    private final UserService userService;

    public CompanyService(UserService userService) {
        this.userService = userService;
    }
}
