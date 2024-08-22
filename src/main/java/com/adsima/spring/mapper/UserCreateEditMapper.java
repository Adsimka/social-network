package com.adsima.spring.mapper;

import com.adsima.spring.database.entity.Company;
import com.adsima.spring.database.entity.User;
import com.adsima.spring.database.repository.CompanyRepository;
import com.adsima.spring.dto.UserCreateEditDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.Optional;
import java.util.function.Predicate;

@Component
@RequiredArgsConstructor
public class UserCreateEditMapper implements Mapper<UserCreateEditDto, User> {

    private final CompanyRepository companyRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User map(UserCreateEditDto object) {
        User user = new User();
        buildUser(object, user);
        return user;
    }

    private Company getCompany(Integer companyId) {
        return Optional.ofNullable(companyId)
                .flatMap(companyRepository::findById)
                .orElse(null);
    }

    public User map(UserCreateEditDto user, User entity) {
        buildUser(user, entity);
        return entity;
    }

    private void buildUser(UserCreateEditDto object, User user) {
        user.setUsername(object.getUsername());
        user.setFirstname(object.getFirstname());
        user.setLastname(object.getLastname());
        user.setBirthDate(object.getBirthDate());
        user.setRole(object.getRole());
        user.setCompany(getCompany(object.getCompanyId()));

        Optional.ofNullable(object.getRawPassword())
                .filter(StringUtils::hasText)
                .map(passwordEncoder::encode)
                .ifPresent(user::setPassword);

        Optional.ofNullable(object.getImage())
                .filter(Predicate.not(MultipartFile::isEmpty))
                .ifPresent(image -> user.setImage(image.getOriginalFilename()));
    }
}
