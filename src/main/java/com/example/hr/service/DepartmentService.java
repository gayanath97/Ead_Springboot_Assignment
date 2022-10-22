package com.example.hr.service;

import com.example.hr.dto.DepartmentDto;
import com.example.hr.entity.Department;
import com.example.hr.repository.DepartmentRepository;
import com.example.hr.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class DepartmentService {

    private DepartmentRepository departmentRepository;

    @Autowired
    public DepartmentService(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    public CommonResponse saveDepartment(DepartmentDto departmentDto) {

        CommonResponse commonResponse = new CommonResponse();

        try {
            Department department = new Department();

            department.setName(departmentDto.getName());
            department.setFloor(departmentDto.getFloor());
            department.setNoOfPcs(Integer.valueOf(departmentDto.getNoOfPcs()));

            departmentRepository.save(department);
            commonResponse.setStatus(true);
        } catch (Exception e) {
            System.out.println(e);
        }
        return commonResponse;
    }
}
