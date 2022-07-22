package com.microservice.departmentms.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.microservice.departmentms.entity.DepartmentEntity;
import com.microservice.departmentms.service.DepartmentService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/departments")
@RequiredArgsConstructor
@Slf4j
public class DepartmentController {

    private final DepartmentService departmentService;

    @PostMapping
    public DepartmentEntity saveDepartment(@RequestBody DepartmentEntity d) {
        log.info("method: saveDepartment, detail: {}", d);
        return departmentService.save(d);
    }

    @GetMapping("/{id}")
    public DepartmentEntity findDepartmentById(@PathVariable Long id) {
        log.info("method: findDepartmentById, id: {}", id);
        return departmentService.findById(id);
    }
}
