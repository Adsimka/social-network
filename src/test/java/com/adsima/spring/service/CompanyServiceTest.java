package com.adsima.spring.service;

import com.adsima.spring.database.entity.Company;
import com.adsima.spring.database.repository.CompanyRepository;
import com.adsima.spring.database.repository.UserRepository;
import com.adsima.spring.dto.CompanyReadDto;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Collections;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.doReturn;

@ExtendWith(SpringExtension.class)
class CompanyServiceTest
{
    private static final Integer COMPANY_ID = 1;
    @Mock
    private UserService userService;
    @Mock
    private CompanyRepository companyRepository;
    @Mock
    private ApplicationEventPublisher eventPublisher;

    @Test
    void findById() {
        doReturn(Optional.of(new Company(COMPANY_ID, null, Collections.emptyMap())))
                .when(companyRepository).findById(COMPANY_ID);

        var actualResult = companyRepository.findById(COMPANY_ID);
        assertTrue(actualResult.isPresent());

        var exceptedResult = new CompanyReadDto(COMPANY_ID);
        actualResult.ifPresent(actual -> assertThat(exceptedResult).isEqualTo(actual));
    }
}