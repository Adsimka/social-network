package com.adsima.spring.integration.service;

import com.adsima.spring.service.UserService;
import com.adsima.spring.integration.annotation.IntegrationTest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@IntegrationTest
@RequiredArgsConstructor
@Slf4j
public class UserServiceIT
{
    private final UserService userService;

    @Test
    void test() {
        log.info("UserService: {}", userService);
        assertNotNull(userService);
    }
}
