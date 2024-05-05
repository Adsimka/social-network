package com.adsima.database.repository;

import com.adsima.bpp.InjectBean;
import com.adsima.database.pool.ConnectionPool;
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
