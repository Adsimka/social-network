package com.adsima.spring.database.repository;

import com.adsima.spring.bpp.Audit;
import com.adsima.spring.bpp.Transaction;
import com.adsima.spring.database.entity.Company;
import com.adsima.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@ToString
@Audit
@Transaction
@Repository
public class CompanyRepository implements CRUDRepository<Long, Company>
{
    private final ConnectionPool pool1;
    private final Integer poolSize;

    public CompanyRepository(ConnectionPool pool1,
                             @Value("${db.pool.size}") Integer poolSize) {
        this.pool1 = pool1;
        this.poolSize = poolSize;
    }

    @PostConstruct
    void initialize() {
        System.out.println("Initializing CompanyRepository");
    }

    @Override
    public Optional<Company> findById(Long id) {
        System.out.println("searching company by id: " + id);
        return Optional.of(new Company(id));
    }

    @Override
    public void delete(Company company) {
        System.out.println("Deleting company: " + company);
    }
}
