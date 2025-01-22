package com.ilya.spring.service;

import com.ilya.spring.database.UserRepository;
import com.ilya.spring.database.CompanyRepository;
import com.ilya.spring.database.abstractioins.CrudRepository;
import com.ilya.spring.database.entity.Company;
import com.ilya.spring.dto.CompanyReadDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CompanyService {
    private final UserService userService;
    private final CrudRepository<Company, Integer> companyRepository;

    public Optional<CompanyReadDTO> findById(Integer id){
        return companyRepository.findById(id)
                .map(entity -> new CompanyReadDTO(entity.getId()));
    }
}
