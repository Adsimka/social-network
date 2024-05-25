package com.adsima.spring.database.repository;

import com.adsima.spring.database.entity.Role;
import com.adsima.spring.database.entity.User;
import com.adsima.spring.dto.PersonalInfo;
import com.adsima.spring.dto.UserFilter;

import java.util.List;

public interface FilterUserRepository {

    List<PersonalInfo> findAllByCompanyIdAndRole(Integer companyId, Role role);

    List<User> findAllByFilter(UserFilter filter);
}
