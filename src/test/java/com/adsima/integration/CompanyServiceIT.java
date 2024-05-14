package com.adsima.integration;

import com.adsima.spring.dto.CompanyReadDto;
import com.adsima.spring.service.CompanyService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CompanyServiceIT
{
    private static final Long COMPANY_ID = 1L;
    @Autowired
    private CompanyService companyService;

    @Test
    void findById() {
        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());

        var exceptedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(exceptedResult, actual));
    }
}
