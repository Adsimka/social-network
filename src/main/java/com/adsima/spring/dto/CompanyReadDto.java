package com.adsima.spring.dto;

import lombok.Builder;

@Builder
public record CompanyReadDto(Integer id,
                             String name) {
}
