package com.adsima.spring.service;

import com.adsima.spring.database.repository.CompanyRepository;
import com.adsima.spring.dto.CompanyReadDto;
import com.adsima.spring.listener.entity.AccessType;
import com.adsima.spring.listener.entity.EntityEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class CompanyService {

//    private final CompanyRepository companyRepository;
//    private final ApplicationEventPublisher eventPublisher;
//
//    public Optional<CompanyReadDto> findById(Integer id) {
//        return companyRepository.findById(id)
//                .map(entity ->  {
//                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
//                    return new CompanyReadDto(entity.getId());
//                });
//    }
}
