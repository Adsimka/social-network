package com.adsima.spring.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
//                    return new CompanyReadDto(entity.getId(), null);
//                });
//    }
}
