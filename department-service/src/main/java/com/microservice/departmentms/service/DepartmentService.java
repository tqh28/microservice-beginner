package com.microservice.departmentms.service;

import org.springframework.stereotype.Service;

import com.microservice.departmentms.entity.DepartmentEntity;
import com.microservice.departmentms.repository.DepartmenRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmenRepository departmenRepository;

    public DepartmentEntity save(DepartmentEntity d) {
        log.info("method: save, save department entity");
        return departmenRepository.save(d);
    }

    public DepartmentEntity findById(Long id) {
        log.info("method: findById, find department entity with id: {}", id);
        return departmenRepository.findById(id).get();
    }
}
