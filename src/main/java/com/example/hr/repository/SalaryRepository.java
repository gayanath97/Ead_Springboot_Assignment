package com.example.hr.repository;

import com.example.hr.entity.Salary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalaryRepository extends JpaRepository<Salary,Long> {


}
