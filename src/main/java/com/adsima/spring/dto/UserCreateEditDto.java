package com.adsima.spring.dto;

import com.adsima.spring.database.entity.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@FieldNameConstants
@Builder
@Value
public class UserCreateEditDto {

    @Email
    String username;

    LocalDate birthDate;

    @NotBlank
    String firstname;

    @NotBlank
    String lastname;

    Role role;

    @NotNull
    Integer companyId;
}
