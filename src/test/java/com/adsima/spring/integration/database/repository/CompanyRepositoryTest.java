package com.adsima.spring.integration.database.repository;

import com.adsima.spring.database.entity.Company;
import com.adsima.spring.integration.annotation.IntegrationTest;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@IntegrationTest
@RequiredArgsConstructor
@Transactional
class CompanyRepositoryTest {

    private static final Logger log = LoggerFactory.getLogger(CompanyRepositoryTest.class);
    private final EntityManager entityManager;

    @Test
    void findById() {
        Company company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }
}