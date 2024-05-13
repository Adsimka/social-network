package com.adsima.spring.config;

import com.adsima.spring.config.condition.JpaCondition;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

@Slf4j
@Configuration
@Conditional(JpaCondition.class)
public class JpaConfiguration {

    @PostConstruct
    public void init() {
        log.info("JpaConfiguration is init");
    }
}
