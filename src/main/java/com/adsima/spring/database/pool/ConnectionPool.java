package com.adsima.spring.database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Value;

@Component("pool1")
@RequiredArgsConstructor
public class ConnectionPool
{
    @Value("${db.username}")
    private final String username;
    @Value("${db.pool.size}")
    private final Integer poolSize;

    @PostConstruct
    private void init() {
        System.out.println("Initialization of connection pool - " + ConnectionPool.class.getName());
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Destroying connection pool");
    }
}
