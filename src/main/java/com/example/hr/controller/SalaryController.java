package com.example.hr.controller;


import com.example.hr.dto.SalaryDto;
import com.example.hr.service.SalaryService;
import com.example.hr.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/salary")
public class SalaryController {

    private SalaryService salaryService;

    @Autowired
    public SalaryController(SalaryService salaryService) {
        this.salaryService = salaryService;
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public CommonResponse saveSalary(@RequestBody SalaryDto salaryDto){
        return salaryService.saveSalary(salaryDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CommonResponse updateSalary(@RequestBody SalaryDto salaryDto,@PathVariable String id){
        return salaryService.updateSalary(salaryDto,id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CommonResponse deleteSalary(@PathVariable String id){

        return salaryService.deleteSalary(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public CommonResponse getSalaryById(@PathVariable String id){

        return salaryService.getSalaryById(id);
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('ADMIN')")
    public CommonResponse getAllSalaries(){

        return salaryService.getAllSalaries();
    }

}
