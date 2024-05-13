package com.adsima.spring.config;

import com.adsima.spring.database.pool.ConnectionPool;
import com.adsima.spring.database.repository.UserRepository;
import com.adsima.web.config.WebConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Slf4j
@Import(WebConfiguration.class)
@Configuration
public class ApplicationConfiguration
{
    @Bean("pool2")
    @Profile("prod")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        log.info("Initializing connection pool2");
        return new ConnectionPool(username, 20);
    }

    @Bean
    @Profile("web")
    public UserRepository userRepository2(@Qualifier("pool2") ConnectionPool pool2) {
        return new UserRepository(pool2);
    }
}
