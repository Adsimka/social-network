package com.adsima;

import com.adsima.spring.config.ApplicationConfiguration;
import com.adsima.spring.database.pool.ConnectionPool;
import com.adsima.spring.database.repository.CRUDRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner
{
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            var connectionPool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool + "pool1");

            var companyRepository = context.getBean("companyRepository", CRUDRepository.class);
            System.out.println(companyRepository.findById(1L));
        }
    }
}
