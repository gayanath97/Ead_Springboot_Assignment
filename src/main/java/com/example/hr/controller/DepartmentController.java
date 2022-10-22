package com.example.hr.controller;

import com.example.hr.dto.DepartmentDto;
import com.example.hr.service.DepartmentService;
import com.example.hr.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/department")
public class DepartmentController {

    private DepartmentService departmentService;

    @Autowired
    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    @PostMapping("/")
    public CommonResponse saveDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.saveDepartment(departmentDto);
    }

    



}
