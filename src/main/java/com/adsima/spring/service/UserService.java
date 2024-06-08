package com.adsima.spring.service;

import com.adsima.spring.database.entity.User;
import com.adsima.spring.database.querydsl.QPredicates;
import com.adsima.spring.database.repository.UserRepository;
import com.adsima.spring.dto.UserCreateEditDto;
import com.adsima.spring.dto.UserFilter;
import com.adsima.spring.dto.UserReadDto;
import com.adsima.spring.mapper.UserCreateEditMapper;
import com.adsima.spring.mapper.UserReadMapper;
import com.querydsl.core.types.Predicate;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

import static com.adsima.spring.database.entity.QUser.user;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService
{
    private final UserRepository userRepository;
    private final ImageService imageService;

    private final UserReadMapper userReadMapper;
    private final UserCreateEditMapper userCreateEditMapper;

    public Page<UserReadDto> findAll(UserFilter userFilter, Pageable pageable) {
        Predicate predicate = QPredicates.builder()
                .add(userFilter.firstname(), user.firstname::containsIgnoreCase)
                .add(userFilter.lastname(), user.lastname::containsIgnoreCase)
                .add(userFilter.birthDate(), user.birthDate::before)
                .build();

        return userRepository.findAll(predicate, pageable)
                .map(userReadMapper::map);
    }

    public List<UserReadDto> findAll() {
        return userRepository.findAll().stream()
                .map(userReadMapper::map)
                .toList();
    }

    public Optional<UserReadDto> findById(Long id) {
        return userRepository.findById(id)
                .map(userReadMapper::map);
    }

    @Transactional
    public UserReadDto create(UserCreateEditDto user) {
        return Optional.of(user)
                .map(dto -> {
                    uploadImage(dto.getImage());
                    return userCreateEditMapper.map(dto);
                })
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map)
                .orElseThrow();
    }

    @Transactional
    public Optional<UserReadDto> update(Long id, UserCreateEditDto user) {
        return userRepository.findById(id)
                .map(entity -> {
                    uploadImage(user.getImage());
                    return userCreateEditMapper.map(user, entity);
                })
                .map(userRepository::saveAndFlush)
                .map(userReadMapper::map);
    }

    @Transactional
    public boolean delete(Long id) {
        return userRepository.findById(id)
                .map(user -> {
                    userRepository.delete(user);
                    userRepository.flush();
                    return true;
                })
                .orElse(false);
    }

    public Optional<byte[]> findByAvatar(Long id) {
        return userRepository.findById(id)
                .map(User::getImage)
                .filter(StringUtils::hasText)
                .flatMap(imageService::get);
    }

    @SneakyThrows
    private void uploadImage(MultipartFile image) {
        if(!image.isEmpty()) {
            imageService.upload(image.getOriginalFilename(), image.getInputStream());
        }
    }
}
