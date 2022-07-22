package com.microservice.userms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.microservice.userms.dto.DepartmentDto;
import com.microservice.userms.dto.UserResponseDto;
import com.microservice.userms.entity.UserEntity;
import com.microservice.userms.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    @Value("${service.department.uri}")
    private String departmentUri;

    public UserEntity save(UserEntity u) {
        log.info("method: save, save user: {}", u);
        return userRepository.save(u);
    }

    public List<UserEntity> findByDepartmentId(Long departmentId) {
        log.info("method: findByDepartmentId, departmentId: {}", departmentId);
        return userRepository.findByDepartmentId(departmentId);
    }

    public UserResponseDto findUserWithDepartmentByUserId(Long userId) {
        log.info("method: findUserWithDepartmentByUserId, userId: {}", userId);
        UserEntity userEntity = userRepository.findById(userId).get();

        DepartmentDto departmentDto = restTemplate
                .getForObject("http://department-service/departments/" + userEntity.getDepartmentId(), DepartmentDto.class);
        log.info("method: findUserWithDepartmentByUserId, received department with id: {}", userEntity.getDepartmentId());
        return new UserResponseDto(userEntity.getId(), userEntity.getEmail(), userEntity.getFirstName(),
                userEntity.getLastName(), departmentDto);
    }

}
