package com.adsima.spring.database.repository;

import com.adsima.spring.database.entity.User;
import com.adsima.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<User> findAllByFilter(UserFilter filter);
}
