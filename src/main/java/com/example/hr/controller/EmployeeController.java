package com.example.hr.controller;

import com.example.hr.dto.EmployeeDto;
import com.example.hr.service.EmployeeService;
import com.example.hr.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public CommonResponse saveEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.saveEmployee(employeeDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CommonResponse updateEmployee(@RequestBody EmployeeDto employeeDto,@PathVariable String id){
        return employeeService.updateEmployee(employeeDto,id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CommonResponse deleteEmployee(@PathVariable String id){
        return employeeService.deleteEmployee(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CommonResponse getEmployeeById(@PathVariable String id){
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public CommonResponse getAllEmployees(){
        return employeeService.getAllEmployees();
    }

}
