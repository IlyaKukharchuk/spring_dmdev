package com.ilya.spring.service;

import com.ilya.spring.database.CompanyRepository;
import com.ilya.spring.database.UserRepository;
import com.ilya.spring.database.abstractioins.CrudRepository;
import com.ilya.spring.database.entity.Company;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private CrudRepository<Company, Integer> companyRepository;
    public UserService(@Qualifier("userRepository") UserRepository userRepository,
                       CrudRepository<Company, Integer> companyRepository){
        this.userRepository = userRepository;
        this.companyRepository = companyRepository;
    }
}
