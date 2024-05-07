package com.adsima.spring.service;

import com.adsima.spring.database.entity.Company;
import com.adsima.spring.database.repository.CRUDRepository;
import com.adsima.spring.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
