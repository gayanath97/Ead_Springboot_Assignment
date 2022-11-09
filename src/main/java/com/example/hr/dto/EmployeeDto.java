package com.example.hr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class EmployeeDto {

    private String id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String email;
    private String department;

}
