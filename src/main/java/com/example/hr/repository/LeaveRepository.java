package com.example.hr.repository;

import com.example.hr.entity.Leave;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<Leave,Long> {
}
