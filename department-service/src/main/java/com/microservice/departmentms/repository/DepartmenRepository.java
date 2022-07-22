package com.microservice.departmentms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.microservice.departmentms.entity.DepartmentEntity;

public interface DepartmenRepository extends JpaRepository<DepartmentEntity, Long>{

}
