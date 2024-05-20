package com.adsima.spring.integration.database.repository;

import com.adsima.spring.database.entity.Company;
import com.adsima.spring.database.repository.CompanyRepository;
import com.adsima.spring.integration.annotation.IntegrationTest;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IntegrationTest
@RequiredArgsConstructor
class CompanyRepositoryTest {

    private static final Integer APPLE_ID = 4;
    private final EntityManager entityManager;
    private final CompanyRepository companyRepository;

    @Test
    void checkFindAllByNameContaining() {
        List<Company> companies = companyRepository.findAllByNameContainingIgnoreCase("a");
        companies.forEach(System.out::println);

        assertFalse(companies.isEmpty());
    }

    @Test
    void checkFindByNameQuery() {
        Optional<Company> google = companyRepository.findByName("Google");
        assertTrue(google.isPresent());
    }

    @Test
    void findById() {
        Company company = entityManager.find(Company.class, 1);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    void delete() {
        var maybeCompany = companyRepository.findById(APPLE_ID);
        assertTrue(maybeCompany.isPresent());
        maybeCompany.ifPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(APPLE_ID).isEmpty());
    }
}