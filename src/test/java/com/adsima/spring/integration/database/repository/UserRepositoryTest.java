package com.adsima.spring.integration.database.repository;

import com.adsima.spring.database.entity.Role;
import com.adsima.spring.database.entity.User;
import com.adsima.spring.database.repository.UserRepository;
import com.adsima.spring.integration.annotation.IntegrationTest;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@IntegrationTest
@RequiredArgsConstructor
class UserRepositoryTest
{
    private final UserRepository userRepository;

    @Test
    void checkUpdate() {
        var ivan = userRepository.getById(1L);
        assertSame(Role.ADMIN, ivan.getRole());

        var resultCount = userRepository.updateRole(Role.USER.toString(), 1L, 5L);
        assertEquals(2, resultCount);

        var theSameIvan = userRepository.getById(1L);
        assertSame(Role.USER, theSameIvan.getRole());
    }

    @Test
    void findAllBy() {
        List<User> users = userRepository.findAllBy("a", "ov");
        assertThat(users).hasSize(3);
    }

    @Test
    void findByUsername() {
        List<User> users = userRepository.findByUsername("petr@gmail.com");
        assertThat(users.isEmpty()).isFalse();
    }
}