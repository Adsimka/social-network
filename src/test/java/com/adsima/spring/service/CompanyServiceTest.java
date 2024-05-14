package com.adsima.spring.service;

import com.adsima.spring.database.entity.Company;
import com.adsima.spring.database.repository.CRUDRepository;
import com.adsima.spring.dto.CompanyReadDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.ApplicationEventPublisher;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class CompanyServiceTest
{
    private static final Long COMPANY_ID = 1L;
    @Mock
    private UserService userService;
    @Mock
    private CRUDRepository<Long, Company> crudRepository;
    @Mock
    private ApplicationEventPublisher eventPublisher;
    @InjectMocks
    private CompanyService companyService;

    @Test
    void findById() {
        doReturn(Optional.of(new Company(COMPANY_ID)))
                .when(crudRepository).findById(COMPANY_ID);

        var actualResult = companyService.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());

        var exceptedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertEquals(exceptedResult, actual));
    }
}