package com.adsima.spring.service;

import com.adsima.spring.database.entity.Company;
import com.adsima.spring.database.repository.CRUDRepository;
import com.adsima.spring.dto.CompanyReadDto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final UserService userService;
    private final CRUDRepository<Long, Company> companyCRUDRepository;

    public CompanyService(UserService userService, CRUDRepository<Long, Company> companyCRUDRepository) {
        this.userService = userService;
        this.companyCRUDRepository = companyCRUDRepository;
    }

    public Optional<CompanyReadDto> findById(Long id) {
        return companyCRUDRepository.findById(id)
                .map(entity -> new CompanyReadDto(entity.id()));
    }

}
