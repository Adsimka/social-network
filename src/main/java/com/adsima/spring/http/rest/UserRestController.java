package com.adsima.spring.http.rest;

import com.adsima.spring.dto.PageResponse;
import com.adsima.spring.dto.UserCreateEditDto;
import com.adsima.spring.dto.UserFilter;
import com.adsima.spring.dto.UserReadDto;
import com.adsima.spring.service.CompanyService;
import com.adsima.spring.service.UserService;
import com.adsima.spring.validation.groups.CreateAction;
import com.adsima.spring.validation.groups.UpdateAction;
import jakarta.validation.groups.Default;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;
import static org.springframework.http.ResponseEntity.*;

@RequestMapping("/api/v1/users")
@RestController
@RequiredArgsConstructor
public class UserRestController {

    private final UserService userService;
    private final CompanyService companyService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public PageResponse<UserReadDto> findAll(UserFilter userFilter, Pageable pageable) {
        Page<UserReadDto> page = userService.findAll(userFilter, pageable);
        return PageResponse.of(page);
    }

    @GetMapping("/{id}")
    public UserReadDto findById(@PathVariable("id") Long id) {
        return userService.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/{id}/avatar")
    public ResponseEntity<byte[]> findAvatar(@PathVariable("id") Long id) {
        return userService.findByAvatar(id)
                .map(content -> ok()
                        .header(CONTENT_TYPE, APPLICATION_OCTET_STREAM_VALUE)
                        .contentLength(content.length)
                        .body(content))
                .orElseGet(notFound()::build);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserReadDto create(@Validated({Default.class, CreateAction.class}) UserCreateEditDto user) {
        return userService.create(user);
    }

    @PutMapping("/{id}")
    public UserReadDto update(@PathVariable("id") Long id,
                       @Validated({Default.class, UpdateAction.class}) UserCreateEditDto user) {
        return userService.update(id, user)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        return userService.delete(id)
                ? noContent().build()
                : notFound().build();
    }
}
