package database.repository;

import bpp.Audit;
import bpp.InjectBean;
import bpp.Transaction;
import database.pool.ConnectionPool;
import database.entity.Company;
import jakarta.annotation.PostConstruct;
import lombok.ToString;

import java.util.Optional;

@ToString
@Audit
@Transaction
public class CompanyRepository implements CRUDRepository<Long, Company> {

    @InjectBean
    private ConnectionPool connectionPool;

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
