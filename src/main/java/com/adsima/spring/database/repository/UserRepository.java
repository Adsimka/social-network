package com.adsima.spring.database.repository;

import com.adsima.spring.database.entity.User;
import com.adsima.spring.dto.PersonalInfo;
import jakarta.persistence.LockModeType;
import jakarta.persistence.QueryHint;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;

import java.time.LocalDate;
import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>, FilterUserRepository {

    @Query(name = "SELECT firstname," +
            "lastname," +
            "birth_date birthDate " +
            "FROM users " +
            "WHERE company_id = :companyId",
            nativeQuery = true)
    List<PersonalInfo> findAllByCompanyId(Integer companyId);

    @QueryHints(@QueryHint(name = "org.hibernate.fetchSize", value = "50"))
    @Lock(LockModeType.PESSIMISTIC_READ)
    List<User> findTop3ByBirthDateBefore(LocalDate date, Sort sort);

    @EntityGraph(attributePaths = {"company", "company.locales"})
    @Query(value = "select u from User u",
            countQuery = "select count(distinct u.firstname) from User u")
    Page<User> findAllBy(Pageable pageable);

    @Query("select u from User u where u.firstname like %:firstname% " +
            "and u.lastname like %:lastname%")
    List<User> findAllBy(String firstname, String lastname);

    @Query(value = "SELECT u.* FROM users u WHERE u.username = :username",
            nativeQuery = true)
    List<User> findByUsername(String username);

    @Modifying(clearAutomatically = true, flushAutomatically = true)
    @Query(value = "UPDATE users " +
            "SET role = :role " +
            "WHERE id in (:ids)",
            nativeQuery = true)
    int updateRole(String role, Long... ids);
}
