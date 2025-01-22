package com.ilya.spring.service;

import com.ilya.spring.database.CompanyRepository;
import com.ilya.spring.database.UserRepository;
import com.ilya.spring.database.abstractioins.CrudRepository;
import com.ilya.spring.database.entity.Company;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository2;
    private final CrudRepository<Company, Integer> companyRepository;
}
