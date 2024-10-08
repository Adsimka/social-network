package com.adsima.spring.integration.database.repository;

import com.adsima.spring.database.entity.Role;
import com.adsima.spring.database.entity.User;
import com.adsima.spring.database.repository.UserRepository;
import com.adsima.spring.dto.PersonalInfo;
import com.adsima.spring.dto.UserFilter;
import com.adsima.spring.integration.IntegrationTestBase;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

@RequiredArgsConstructor
class UserRepositoryTest extends IntegrationTestBase
{
    private final UserRepository userRepository;

    @Test
    void checkBatchUpdate() {
        List<User> users = userRepository.findAll();
        userRepository.updateCompanyAndRole(users);
        System.out.println();
    }



    @Test
    void checkJDBCTemplate() {
        List<PersonalInfo> infoList = userRepository.findAllByCompanyIdAndRole(1, Role.USER);
        System.out.println();
    }

    @Test
    void checkCustomRepository() {
        UserFilter filter = new UserFilter(
                null,
                "ov",
                LocalDate.now());
        List<User> users = userRepository.findAllByFilter(filter);
        assertThat(users).hasSize(4);
    }

    @Test
    void checkProjection() {
        List<PersonalInfo> personalInfos = userRepository.findAllByCompanyId(1);
        assertThat(personalInfos).hasSize(2);
    }

    @Test
    void checkPageable() {
        var sortBy = Sort.sort(User.class);
        var pageableBy = PageRequest.of(1, 2, sortBy.by(User::getId));

        Page<User> users = userRepository.findAllBy(pageableBy);
        while (users.hasNext()) {
            users = userRepository.findAllBy(users.nextPageable());
            users.forEach(u -> System.out.println(u.getId()));
        }
    }

    @Test
    void checkSort() {
        var sortBy = Sort.sort(User.class);
        var sort = sortBy.by(User::getFirstname).and(sortBy.by(User::getLastname));

        userRepository.findTop3ByBirthDateBefore(LocalDate.now(), sort);
    }

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
        List<User> users = userRepository.findAllByUsername("petr@gmail.com");
        assertThat(users.isEmpty()).isFalse();
    }
}