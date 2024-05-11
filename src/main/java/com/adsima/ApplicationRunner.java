package com.adsima;

import com.adsima.spring.config.ApplicationConfiguration;
import com.adsima.spring.database.pool.ConnectionPool;
import com.adsima.spring.database.repository.CRUDRepository;
import com.adsima.spring.database.repository.CompanyRepository;
import com.adsima.spring.service.CompanyService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationRunner
{
    public static void main(String[] args) {
        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            var connectionPool = context.getBean("pool1", ConnectionPool.class);
            System.out.println(connectionPool + "pool1");

            var companyService = context.getBean(CompanyService.class);
            System.out.println(companyService.findById(1L));
        }
    }
}
