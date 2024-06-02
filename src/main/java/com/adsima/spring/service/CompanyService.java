package com.adsima.spring.service;

import com.adsima.spring.database.repository.CompanyRepository;
import com.adsima.spring.dto.CompanyReadDto;
import com.adsima.spring.listener.entity.AccessType;
import com.adsima.spring.listener.entity.EntityEvent;
import com.adsima.spring.mapper.CompanyReadMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.adsima.spring.listener.entity.AccessType.*;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CompanyService {

    private final CompanyRepository companyRepository;
    private final ApplicationEventPublisher eventPublisher;

    private final CompanyReadMapper companyReadMapper;

    public Optional<CompanyReadDto> findById(Integer id) {
        return companyRepository.findById(id)
                .map(entity ->  {
                    eventPublisher.publishEvent(new EntityEvent(entity, READ));
                    return companyReadMapper.map(entity);
                });
    }

    public List<CompanyReadDto> findAll() {
        return companyRepository.findAll().stream()
                .map(companyReadMapper::map)
                .toList();
    }
}
