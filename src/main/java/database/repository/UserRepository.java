package database.repository;

import bpp.InjectBean;
import database.pool.ConnectionPool;

public class UserRepository
{
    @InjectBean
    private ConnectionPool connectionPool;
}
