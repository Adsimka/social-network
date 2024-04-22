package database.pool;

import java.util.List;
import java.util.Map;

public class ConnectionPool
{
    private final String username;
    private final Integer poolSize;
    private final List<Object> args;
    private final Map<String, Object> properties;


    public ConnectionPool(String username, int poolSize, List<Object> args, Map<String, Object> properties) {
        this.username = username;
        this.poolSize = poolSize;
        this.args = args;
        this.properties = properties;
    }

    @Override
    public String toString() {
        return "ConnectionPool{" +
                "username='" + username + '\'' +
                ", poolSize=" + poolSize +
                ", args=" + args +
                ", properties=" + properties +
                '}';
    }

    private void init() {
        System.out.println("Initialization of connection pool");
    }

    private void destroy() {
        System.out.println("Destroying connection pool");
    }
}
