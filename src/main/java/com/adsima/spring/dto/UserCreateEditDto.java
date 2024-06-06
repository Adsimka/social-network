package com.adsima.spring.dto;

import com.adsima.spring.database.entity.Role;
import com.adsima.spring.validation.UserInfo;
import com.adsima.spring.validation.groups.UpdateAction;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Value;
import lombok.experimental.FieldNameConstants;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDate;

@Value
@FieldNameConstants
@UserInfo(groups = UpdateAction.class)
@Builder
public class UserCreateEditDto {
    @Email
    String username;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    LocalDate birthDate;

    @Size(min = 3, max = 64)
    String firstname;

    String lastname;

    Role role;

    Integer companyId;

    MultipartFile image;
}