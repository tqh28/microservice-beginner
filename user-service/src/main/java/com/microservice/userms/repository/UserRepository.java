package com.microservice.userms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.userms.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    List<UserEntity> findByDepartmentId(Long departmentId);

}
