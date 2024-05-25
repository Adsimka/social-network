package com.adsima.spring.integration.service;

import com.adsima.spring.database.repository.CompanyRepository;
import com.adsima.spring.dto.CompanyReadDto;
import com.adsima.spring.integration.annotation.IntegrationTest;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@IntegrationTest
@RequiredArgsConstructor
public class CompanyServiceIT
{
    private static final Integer COMPANY_ID = 1;
    private final CompanyRepository companyRepository;

//    @Test
//    void findById() {
//        var actualResult = companyRepository.findById(COMPANY_ID);
//        assertTrue(actualResult.isPresent());
//
//        var exceptedResult = new CompanyReadDto(COMPANY_ID);
//        actualResult.ifPresent(actual -> assertEquals(exceptedResult, actual));
//    }
}
