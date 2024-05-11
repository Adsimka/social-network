package com.adsima.spring.database.repository;

import com.adsima.spring.database.pool.ConnectionPool;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope(BeanDefinition.SCOPE_PROTOTYPE)
public class UserRepository
{
    private final ConnectionPool connectionPool;

    public UserRepository(@Qualifier("pool1") ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }
}
