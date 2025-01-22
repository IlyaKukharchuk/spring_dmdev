package com.ilya.spring.service.integration;

import com.ilya.spring.Main;
import com.ilya.spring.dto.CompanyReadDTO;
import com.ilya.spring.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.ConfigDataApplicationContextInitializer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

//or just @SpringBootTest
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = Main.class, initializers = ConfigDataApplicationContextInitializer.class)
class CompanyServiceIntegrationTest {

    private static final Integer COMPANY_ID = 1;

    @Autowired
    private CompanyService companyService;
    @Test
    void testById(){
        var actualResult = companyService.findById(COMPANY_ID);

        assertTrue(actualResult.isPresent());

        var expectedResult = new CompanyReadDTO(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(expectedResult, actual));
    }

}