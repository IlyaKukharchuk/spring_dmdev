package com.ilya.spring.service;

import com.ilya.spring.database.abstractioins.CrudRepository;
import com.ilya.spring.database.entity.Company;
import com.ilya.spring.dto.CompanyReadDTO;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.internal.matchers.Null;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest {
    private static final Integer COMPANY_ID = 1;

    @Mock
    private UserService userService;
    @Mock
    private CrudRepository<Company, Integer> companyRepository;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void testById(){
        doReturn(Optional.of(new Company(COMPANY_ID, null, Collections.emptyMap())))
                .when(companyRepository).findById(COMPANY_ID);

        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDTO(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }

}