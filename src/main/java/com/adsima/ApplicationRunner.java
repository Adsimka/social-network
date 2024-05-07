package com.adsima;

import com.adsima.config.ApplicationConfiguration;
import com.adsima.database.pool.ConnectionPool;
import com.adsima.database.repository.CRUDRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner
{
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            var connectionPool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool);

            var companyRepository = context.getBean("companyRepository", CRUDRepository.class);

            System.out.println(companyRepository);
        }
        System.out.println();
    }
}
