package com.microservice.userms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.userms.dto.UserResponseDto;
import com.microservice.userms.entity.UserEntity;
import com.microservice.userms.service.UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public UserEntity saveUser(@RequestBody UserEntity u) {
        log.info("method: saveUser, in controller");
        return userService.save(u);
    }

    @GetMapping("/{userId}")
    public UserResponseDto findUserWithDepartmentByUserId(@PathVariable
            Long userId) {
        log.info("method: findUserWithDepartmentByUserId, in controller");
        return userService.findUserWithDepartmentByUserId(userId);
    }
}
