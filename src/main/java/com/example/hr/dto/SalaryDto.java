package com.example.hr.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SalaryDto {

    private String month;
    private String email;
    private String basic;
    private String ot;
    private String allowance;

}
