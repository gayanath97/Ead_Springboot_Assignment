package com.example.hr.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LeaveDto {

    private String email;
    private String date;
    private String description;
    private String statuss;

}
