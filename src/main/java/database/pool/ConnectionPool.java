package database.pool;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
public class ConnectionPool
{
    private final String username;

    private final Integer poolSize;

    private final List<Object> args;

    private final Map<String, Object> properties;


    @Override
    public String toString() {
        return "ConnectionPool{" +
                "username='" + username + '\'' +
                ", poolSize=" + poolSize +
                ", args=" + args +
                ", properties=" + properties +
                '}';
    }

    @PostConstruct
    private void init() {
        System.out.println("Initialization of connection pool");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("Destroying connection pool");
    }
}
