package com.adsima.spring.dto;

import com.adsima.spring.database.entity.Role;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@FieldNameConstants
@Builder
@Value
public class UserCreateEditDto {

    String username;

    LocalDate birthDate;

    String firstname;

    String lastname;

    Role role;

    Integer companyId;
}
