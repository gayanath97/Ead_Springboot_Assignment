package com.example.hr.controller;

import com.example.hr.dto.LeaveDto;
import com.example.hr.service.LeaveService;
import com.example.hr.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/leave")
public class LeaveController {

    private LeaveService leaveService;

    @Autowired
    public LeaveController(LeaveService leaveService) {
        this.leaveService = leaveService;
    }

    @PostMapping("/")
    @PreAuthorize("hasRole('USER')")
    public CommonResponse saveLeave(@RequestBody LeaveDto leaveDto){
        return leaveService.saveLeave(leaveDto);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public CommonResponse updateLeave(@RequestBody LeaveDto leaveDto,@PathVariable String id){
        return leaveService.updateLeave(leaveDto,id);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public CommonResponse deleteLeave(@PathVariable String id){

        return leaveService.deleteLeave(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('USER')")
    public CommonResponse getLeaveById(@PathVariable String id){

        return leaveService.getLeaveById(id);
    }

    @GetMapping("/")
    @PreAuthorize("hasRole('USER')")
    public CommonResponse getAllLeave(){

        return leaveService.getAllLeave();
    }



}
