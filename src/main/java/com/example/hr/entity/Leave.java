package com.example.hr.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="leaves")
public class Leave {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "leave_id")
    private Long id;

    private String email;
    @Column(name = "`date`")
    private Date date;
    @Column(name = "`description`")
    private String description;
    private String statuss;


}
