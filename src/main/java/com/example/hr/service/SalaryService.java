package com.example.hr.service;

import com.example.hr.dto.SalaryDto;
import com.example.hr.dto.SalaryDtoRes;
import com.example.hr.entity.Salary;
import com.example.hr.repository.SalaryRepository;
import com.example.hr.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SalaryService {

    private SalaryRepository salaryRepository;

    @Autowired
    public SalaryService(SalaryRepository salaryRepository) {
        this.salaryRepository = salaryRepository;
    }

    public CommonResponse saveSalary(SalaryDto salaryDto) {

        CommonResponse commonResponse = new CommonResponse();

        try {
            Salary salary = new Salary();

            salary.setMonth(salaryDto.getMonth());
            salary.setEmail(salaryDto.getEmail());
            salary.setBasic(Double.valueOf(salaryDto.getBasic()));
            salary.setOt(Double.valueOf(salaryDto.getOt()));
            salary.setAllowance(Double.valueOf(salaryDto.getAllowance()));
            salary.setTotal(
                    Double.valueOf(salaryDto.getBasic())+
                            Double.valueOf(salaryDto.getOt())+
                            Double.valueOf(salaryDto.getAllowance())
            );

            salaryRepository.save(salary);
            commonResponse.setStatus(true);
        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    public CommonResponse updateSalary(SalaryDto salaryDto, String id) {

        CommonResponse commonResponse = new CommonResponse();

        try {
            Salary salary = salaryRepository.getById(Long.valueOf(id));

            salary.setMonth(salaryDto.getMonth());
            salary.setEmail(salaryDto.getEmail());
            salary.setBasic(Double.valueOf(salaryDto.getBasic()));
            salary.setOt(Double.valueOf(salaryDto.getOt()));
            salary.setAllowance(Double.valueOf(salaryDto.getAllowance()));
            salary.setTotal(
                    Double.valueOf(salaryDto.getBasic())+
                            Double.valueOf(salaryDto.getOt())+
                            Double.valueOf(salaryDto.getAllowance())
            );

            salaryRepository.save(salary);
            commonResponse.setStatus(true);
        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    public CommonResponse deleteSalary(String id) {
        CommonResponse commonResponse =new CommonResponse();
        try {

            Salary salary = salaryRepository.getById(Long.valueOf(id));

            salaryRepository.delete(salary);
            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    public CommonResponse getSalaryById(String id) {

        CommonResponse commonResponse = new CommonResponse();

        try {
            Salary salary = salaryRepository.findById(Long.valueOf(id)).get();

            SalaryDtoRes salaryDtoRes = new SalaryDtoRes();

            salaryDtoRes.setMonth(salary.getMonth());
            salaryDtoRes.setEmail(salary.getEmail());
            salaryDtoRes.setBasic(String.valueOf(salary.getBasic()));
            salaryDtoRes.setOt(String.valueOf(salary.getOt()));
            salaryDtoRes.setAllowance(String.valueOf(salary.getAllowance()));
            salaryDtoRes.setTotal(String.valueOf(salary.getTotal()));

            commonResponse.setPayload(Collections.singletonList(salaryDtoRes));
            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    public CommonResponse getAllSalaries() {

        CommonResponse commonResponse = new CommonResponse();

        try {

            List<Salary> salaries = salaryRepository.findAll();

            List<SalaryDtoRes> salaryDtoRes = castSalaryToSalaryDtoRes(salaries);

            commonResponse.setPayload(Collections.singletonList(salaryDtoRes));
            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }

        return commonResponse;
    }

    private List<SalaryDtoRes> castSalaryToSalaryDtoRes(List<Salary> salaries) {

        List<SalaryDtoRes> salaryDtoReses = new ArrayList<>();

        for(Salary salary : salaries){

            SalaryDtoRes salaryDtoRes = new SalaryDtoRes();

            salaryDtoRes.setMonth(salary.getMonth());
            salaryDtoRes.setEmail(salary.getEmail());
            salaryDtoRes.setBasic(String.valueOf(salary.getBasic()));
            salaryDtoRes.setOt(String.valueOf(salary.getOt()));
            salaryDtoRes.setAllowance(String.valueOf(salary.getAllowance()));
            salaryDtoRes.setTotal(String.valueOf(salary.getTotal()));

            salaryDtoReses.add(salaryDtoRes);

        }

        return salaryDtoReses;

    }
}
