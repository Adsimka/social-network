package com.adsima.spring.config;

import com.adsima.spring.config.condition.JpaCondition;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Configuration
@Conditional(JpaCondition.class)
public class JpaConfiguration {

    @PostConstruct
    public void init() {
        System.out.println("JpaConfiguration is init");
    }
}
