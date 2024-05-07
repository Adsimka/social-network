package com.adsima.spring.config;

import com.adsima.spring.database.pool.ConnectionPool;
import com.adsima.spring.database.repository.UserRepository;
import com.adsima.web.config.WebConfiguration;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Import(WebConfiguration.class)
@Configuration
@PropertySource(value = "classpath:application.properties")
@ComponentScan(value = "com.adsima")
public class ApplicationConfiguration
{
    @Bean("pool2")
    @Scope(BeanDefinition.SCOPE_SINGLETON)
    public ConnectionPool pool2(@Value("${db.username}") String username) {
        System.out.println("Initializing connection pool2");
        return new ConnectionPool(username, 20);
    }

    @Bean
    public UserRepository userRepository2(@Qualifier("pool2") ConnectionPool pool2) {
        return new UserRepository(pool2);
    }
}
