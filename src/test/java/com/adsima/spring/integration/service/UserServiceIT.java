package com.adsima.spring.integration.service;

import com.adsima.spring.database.entity.Role;
import com.adsima.spring.dto.UserCreateEditDto;
import com.adsima.spring.dto.UserReadDto;
import com.adsima.spring.integration.IntegrationTestBase;
import com.adsima.spring.mapper.UserReadMapper;
import com.adsima.spring.service.UserService;
import com.adsima.spring.integration.annotation.IntegrationTest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@RequiredArgsConstructor
public class UserServiceIT extends IntegrationTestBase
{
    private static final Long USER_1 = 1L;
    private static final Integer COMPANY_1 = 1;

    private final UserService userService;

    @Test
    void findAll() {
        List<UserReadDto> result = userService.findByAll();
        assertThat(result).hasSize(5);
    }

    @Test
    void findById() {
        Optional<UserReadDto> userReadDto = userService.findById(USER_1);
        assertTrue(userReadDto.isPresent());
        userReadDto.ifPresent(user -> assertEquals("Ivan", user.getFirstname()));
    }

    @Test
    void create() {
        UserCreateEditDto user = buildUserEditDto();
        UserReadDto dto = userService.create(user);
        assertEquals(user.getUsername(), dto.getUsername());
        assertEquals(user.getFirstname(), dto.getFirstname());
        assertEquals(user.getLastname(), dto.getLastname());
        assertEquals(user.getBirthDate(), dto.getBirthDate());
        assertEquals(user.getCompanyId(), dto.getCompanyReadDto().id());
        assertEquals(user.getRole(), dto.getRole());
    }

    @Test
    void update() {
        UserCreateEditDto user = buildUserEditDto();
        Optional<UserReadDto> dto = userService.update(USER_1, user);

        assertTrue(dto.isPresent());
        dto.ifPresent(d -> {
            assertEquals(user.getUsername(), d.getUsername());
            assertEquals(user.getFirstname(), d.getFirstname());
            assertEquals(user.getLastname(), d.getLastname());
            assertEquals(user.getBirthDate(), d.getBirthDate());
            assertEquals(user.getCompanyId(), d.getCompanyReadDto().id());
            assertEquals(user.getRole(), d.getRole());
        });
    }

    @Test
    void delete() {
        boolean deleted = userService.delete(USER_1);
        assertTrue(deleted);
    }

    private UserCreateEditDto buildUserEditDto() {
        return UserCreateEditDto.builder()
                .username("test@mail.ru")
                .firstname("Test")
                .lastname("Test")
                .birthDate(LocalDate.now())
                .role(Role.ADMIN)
                .companyId(COMPANY_1)
                .build();
    }
}
