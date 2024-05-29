package com.adsima.spring.service;

import com.adsima.spring.database.repository.UserRepository;
import com.adsima.spring.dto.UserCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class UserService
{
    private final UserRepository userRepository;

    public List<UserCreateEditDto> findByAll() {
        return null;
    }

    public UserCreateEditDto findById(Long id) {
        return null;
    }

    public void create(UserCreateEditDto user) {
    }

    public void update(Long id, UserCreateEditDto user) {
    }

    public void delete(Long id) {
    }
}
