package com.adsima.spring.database.repository;

import com.adsima.spring.bpp.Audit;
import com.adsima.spring.database.entity.Company;
import com.adsima.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Slf4j
@Repository()
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
@RequiredArgsConstructor
public class CompanyRepository implements CRUDRepository<Long, Company>
{
    @Qualifier("pool2")
    private final ConnectionPool connectionPool;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    void initialize() {
        log.info("Initializing CompanyRepository");
    }

    @Override
    public Optional<Company> findById(Long id) {
        log.info("searching company by id: {}", id);
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company company) {
        log.info("Deleting company: {}", company);
    }
}
