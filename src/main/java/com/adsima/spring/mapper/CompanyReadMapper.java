package com.adsima.spring.mapper;

import com.adsima.spring.database.entity.Company;
import com.adsima.spring.dto.CompanyReadDto;
import org.springframework.stereotype.Component;

@Component
public class CompanyReadMapper implements Mapper<Company, CompanyReadDto> {

    @Override
    public CompanyReadDto map(Company object) {
        return CompanyReadDto.builder()
                .id(object.getId())
                .name(object.getName())
                .build();
    }
}
