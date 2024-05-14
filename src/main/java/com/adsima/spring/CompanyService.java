package com.adsima.spring;

import com.adsima.spring.database.entity.Company;
import com.adsima.spring.database.repository.CRUDRepository;
import com.adsima.spring.dto.CompanyReadDto;
import com.adsima.spring.listener.entity.AccessType;
import com.adsima.spring.listener.entity.EntityEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CompanyService {

    private final UserService userService;
    private final CRUDRepository<Long, Company> companyCRUDRepository;
    private final ApplicationEventPublisher eventPublisher;

    public CompanyService(UserService userService, CRUDRepository<Long, Company> companyCRUDRepository, ApplicationEventPublisher eventPublisher) {
        this.userService = userService;
        this.companyCRUDRepository = companyCRUDRepository;
        this.eventPublisher = eventPublisher;
    }

    public Optional<CompanyReadDto> findById(Long id) {
        return companyCRUDRepository.findById(id)
                .map(entity ->  {
                    eventPublisher.publishEvent(new EntityEvent(entity, AccessType.READ));
                    return new CompanyReadDto(entity.id());
                });
    }

}
