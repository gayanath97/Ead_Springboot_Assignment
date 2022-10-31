package com.example.hr.controller;

import com.example.hr.dto.DepartmentDto;
import com.example.hr.service.DepartmentService;
import com.example.hr.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
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
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public CommonResponse saveDepartment(@RequestBody DepartmentDto departmentDto){
        return departmentService.saveDepartment(departmentDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public CommonResponse updateDepartment(@PathVariable String id,@RequestBody DepartmentDto departmentDto){
        return departmentService.updateDepartment(id,departmentDto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public CommonResponse deleteDepartment(@PathVariable String id){
        return departmentService.deleteDepartment(id);
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public CommonResponse getAllDepartments(){
        return departmentService.getAllDepartments();
    }


    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MANAGER')")
    public CommonResponse getDepartmentById(@PathVariable String id){
        return departmentService.getDepartmentById(id);
    }

}
