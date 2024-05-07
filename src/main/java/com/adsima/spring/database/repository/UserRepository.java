package com.adsima.spring.database.repository;

import com.adsima.spring.bpp.InjectBean;
import com.adsima.spring.database.pool.ConnectionPool;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository
{
    @InjectBean
    private final ConnectionPool pool1;

    public UserRepository(ConnectionPool pool1) {
        this.pool1 = pool1;
    }
}
