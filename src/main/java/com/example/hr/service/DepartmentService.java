package com.example.hr.service;

import com.example.hr.dto.DepartmentDto;
import com.example.hr.entity.Department;
import com.example.hr.repository.DepartmentRepository;
import com.example.hr.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

    public CommonResponse updateDepartment(String id, DepartmentDto departmentDto) {

        CommonResponse commonResponse = new CommonResponse();
        try {

            Department department = departmentRepository.getById(Long.valueOf(id));

            department.setName(departmentDto.getName());
            department.setFloor(departmentDto.getFloor());
            department.setNoOfPcs(Integer.valueOf(departmentDto.getNoOfPcs()));

            departmentRepository.save(department);
            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    public CommonResponse deleteDepartment(String id) {
        CommonResponse commonResponse = new CommonResponse();

        try {
            Department department = departmentRepository.getById(Long.valueOf(id));

            departmentRepository.delete(department);
            commonResponse.setStatus(true);

        }catch (Exception e ){
            System.out.println(e);
        }
        return commonResponse;
    }

    public CommonResponse getAllDepartments() {
        CommonResponse commonResponse = new CommonResponse();

        try {
            List<Department> departments = departmentRepository.findAll();
            List<DepartmentDto> departmentDtos =  castDepartmentsToDepartmentDTOs(departments);
            commonResponse.setPayload(Collections.singletonList(departmentDtos));
            commonResponse.setStatus(true);
        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    private List<DepartmentDto> castDepartmentsToDepartmentDTOs(List<Department> departments) {
        List<DepartmentDto> departmentDtos = new ArrayList<>();

        for(Department department : departments){
            DepartmentDto departmentDto = new DepartmentDto();
            departmentDto.setName(department.getName());
            departmentDto.setFloor(department.getFloor());
            departmentDto.setNoOfPcs(String.valueOf(department.getNoOfPcs()));

            departmentDtos.add(departmentDto);
        }
        return departmentDtos;
    }

    public CommonResponse getDepartmentById(String id) {

        CommonResponse commonResponse = new CommonResponse();
        try {

           Department department = departmentRepository.findById(Long.valueOf(id)).get();

           DepartmentDto departmentDto = new DepartmentDto();

           departmentDto.setName(department.getName());
           departmentDto.setFloor(department.getFloor());
           departmentDto.setNoOfPcs(String.valueOf(department.getNoOfPcs()));

           commonResponse.setPayload(Collections.singletonList(departmentDto));
           commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    public Department findById(String id){
        return departmentRepository.findById(Long.valueOf(id)).get();
    }
}
