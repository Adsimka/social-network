package repository;

import database.pool.ConnectionPool;

public class UserRepository
{
    private final ConnectionPool connectionPool;

    private UserRepository(ConnectionPool connectionPool) {
        this.connectionPool = connectionPool;
    }

    public static UserRepository of(ConnectionPool connectionPool) {
        return new UserRepository(connectionPool);
    }

    @Override
    public String toString() {
        return "UserRepository{" +
                "connectionPool=" + connectionPool +
                '}';
    }
}
