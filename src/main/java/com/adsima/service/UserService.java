package com.adsima.service;

import com.adsima.database.entity.Company;
import com.adsima.database.repository.CRUDRepository;
import com.adsima.database.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
