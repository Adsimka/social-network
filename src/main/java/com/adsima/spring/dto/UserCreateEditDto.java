package com.adsima.spring.dto;

import com.adsima.spring.database.entity.Role;
import com.adsima.spring.validation.UserInfo;
import com.adsima.spring.validation.groups.CreateAction;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.groups.Default;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;

import java.time.LocalDate;

@FieldNameConstants
@Builder
@Value
@UserInfo(groups = {CreateAction.class})
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
