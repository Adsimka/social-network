package com.adsima.spring.database.repository;

import com.adsima.spring.database.entity.Role;
import com.adsima.spring.database.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>
{
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
