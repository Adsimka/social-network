package com.adsima.spring.service;

import com.adsima.spring.database.repository.UserRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService
{
//    private final UserRepository userRepository;
//
//    public UserService(@Qualifier("userRepository") UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
}
