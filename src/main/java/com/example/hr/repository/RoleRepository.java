package com.example.hr.repository;

import com.example.hr.constant.ERole;
import com.example.hr.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {


    Optional<Role> findByName(ERole name);

}
