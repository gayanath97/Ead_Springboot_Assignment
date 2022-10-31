package com.example.hr.service;

import com.example.hr.dto.EmployeeDto;
import com.example.hr.entity.Employee;
import com.example.hr.repository.EmployeeRepository;
import com.example.hr.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    public CommonResponse saveEmployee(EmployeeDto employeeDto) {
        CommonResponse commonResponse = new CommonResponse();

        try {

            Employee employee = new Employee();

            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setPhoneNumber(Integer.valueOf(employeeDto.getPhoneNumber()));
            employee.setEmail(employeeDto.getEmail());
            employee.setDepartment(employeeDto.getDepartment());

            employeeRepository.save(employee);

            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    public CommonResponse updateEmployee(EmployeeDto employeeDto, String id) {

        CommonResponse commonResponse = new CommonResponse();

        try {

            Employee employee = employeeRepository.getById(Long.valueOf(id));

            employee.setFirstName(employeeDto.getFirstName());
            employee.setLastName(employeeDto.getLastName());
            employee.setPhoneNumber(Integer.valueOf(employeeDto.getPhoneNumber()));
            employee.setEmail(employeeDto.getEmail());
            employee.setDepartment(employeeDto.getDepartment());

            employeeRepository.save(employee);

            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    public CommonResponse deleteEmployee(String id) {

        CommonResponse commonResponse = new CommonResponse();

        try {

            Employee employee = employeeRepository.getById(Long.valueOf(id));

            employeeRepository.delete(employee);
            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    public CommonResponse getEmployeeById(String id) {
        CommonResponse commonResponse = new CommonResponse();

        try {

            Employee employee = employeeRepository.findById(Long.valueOf(id)).get();

            EmployeeDto employeeDto = new EmployeeDto();

            employeeDto.setFirstName(employee.getFirstName());
            employeeDto.setLastName(employee.getLastName());
            employeeDto.setPhoneNumber(String.valueOf(employee.getPhoneNumber()));
            employeeDto.setEmail(employee.getEmail());
            employeeDto.setDepartment(employee.getDepartment());

            commonResponse.setPayload(Collections.singletonList(employeeDto));
            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    public CommonResponse getAllEmployees() {

        CommonResponse commonResponse = new CommonResponse();

        try {
            List<Employee> employees = employeeRepository.findAll();
            List<EmployeeDto> employeeDtos = castEmployeesToEmployeeDtos(employees);
            commonResponse.setPayload(Collections.singletonList(employeeDtos));
            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
        return  commonResponse;
    }

    private List<EmployeeDto> castEmployeesToEmployeeDtos(List<Employee> employees) {

        List<EmployeeDto> employeeDtos = new ArrayList<>();

        for(Employee employee : employees){
            EmployeeDto employeeDto = new EmployeeDto();
            employeeDto.setFirstName(employee.getFirstName());
            employeeDto.setLastName(employee.getLastName());
            employeeDto.setPhoneNumber(String.valueOf(employee.getPhoneNumber()));
            employeeDto.setEmail(employee.getEmail());
            employeeDto.setDepartment(employee.getDepartment());

            employeeDtos.add(employeeDto);
        }

        return employeeDtos;
    }

    public Employee findById(String id){
        return employeeRepository.findById(Long.valueOf(id)).get();
    }
}
