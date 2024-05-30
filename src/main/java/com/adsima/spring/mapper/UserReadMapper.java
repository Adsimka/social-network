package com.adsima.spring.mapper;

import com.adsima.spring.database.entity.User;
import com.adsima.spring.dto.CompanyReadDto;
import com.adsima.spring.dto.UserReadDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Optional;

@RequiredArgsConstructor
@Component
public class UserReadMapper implements Mapper<User, UserReadDto> {

    private final CompanyReadMapper companyReadMapper;

    @Override
    public UserReadDto map(User object) {
        CompanyReadDto companyReadDto = Optional.ofNullable(object.getCompany())
                .map(companyReadMapper::map)
                .orElse(null);
        return UserReadDto.builder()
                .id(object.getId())
                .firstname(object.getFirstname())
                .lastname(object.getLastname())
                .username(object.getUsername())
                .role(object.getRole())
                .birthDate(object.getBirthDate())
                .companyReadDto(companyReadDto)
                .build();
    }
}
