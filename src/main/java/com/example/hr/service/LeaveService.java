package com.example.hr.service;

import com.example.hr.dto.LeaveDto;
import com.example.hr.entity.Leave;
import com.example.hr.repository.LeaveRepository;
import com.example.hr.util.CommonResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
public class LeaveService {

    private LeaveRepository leaveRepository;

    @Autowired
    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }


    public CommonResponse saveLeave(LeaveDto leaveDto) {

        CommonResponse commonResponse = new CommonResponse();

        try {

            Leave leave = new Leave();

            leave.setEmail(leaveDto.getEmail());
            leave.setDate(stringToDate(leaveDto.getDate()));
            leave.setDescription(leaveDto.getDescription());
            leave.setStatuss("pending");

            leaveRepository.save(leave);

            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }

       return commonResponse;
    }
    public Date stringToDate(String date){

        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date1 = null;

        try {
            date1 = format.parse(date);
        } catch (Exception e) {
            System.out.println(e);
        }

        return date1;
    }

    public CommonResponse updateLeave(LeaveDto leaveDto, String id) {

        CommonResponse commonResponse = new CommonResponse();

        try {

            Leave leave = leaveRepository.getById(Long.valueOf(id));

            leave.setEmail(leaveDto.getEmail());
            leave.setDate(stringToDate(leaveDto.getDate()));
            leave.setDescription(leaveDto.getDescription());
            leave.setStatuss("pending");

            leaveRepository.save(leave);
            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }

        return commonResponse;
    }

    public CommonResponse deleteLeave(String id) {
        CommonResponse commonResponse = new CommonResponse();
        try {
            Leave leave = leaveRepository.getById(Long.valueOf(id));

            leaveRepository.delete(leave);

            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    public CommonResponse getLeaveById(String id) {

        CommonResponse commonResponse = new CommonResponse();

        try {

            Leave leave = leaveRepository.findById(Long.valueOf(id)).get();

            LeaveDto leaveDto = new LeaveDto();

            leaveDto.setDescription(leave.getDescription());
            leaveDto.setEmail(leave.getEmail());
            leaveDto.setDate(DateTostring(leave.getDate()));
            leaveDto.setStatuss(leave.getStatuss());

            commonResponse.setPayload(Collections.singletonList(leaveDto));
            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
       return commonResponse;
    }

    public String DateTostring(Date date) {
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String date1 = null;

        try {
            date1 = String.valueOf(format.parse(String.valueOf(date)));
        } catch (Exception e) {
            System.out.println(e);
        }

        return date1;

    }

    public CommonResponse getAllLeave() {

        CommonResponse commonResponse = new CommonResponse();

        try {

            List<Leave> leaves = leaveRepository.findAll();

            List<LeaveDto> leaveDtos = castLeavesToLeaveDtos(leaves);

            commonResponse.setPayload(Collections.singletonList(leaveDtos));
            commonResponse.setStatus(true);

        }catch (Exception e){
            System.out.println(e);
        }
        return commonResponse;
    }

    private List<LeaveDto> castLeavesToLeaveDtos(List<Leave> leaves) {

        List<LeaveDto> leaveDtos = new ArrayList<>();

        for(Leave leave : leaves){

            LeaveDto leaveDto = new LeaveDto();

            leaveDto.setEmail(leave.getEmail());
            leaveDto.setDescription(leave.getDescription());
            leaveDto.setDate(DateTostring(leave.getDate()));
            leaveDto.setStatuss(leave.getStatuss());

            leaveDtos.add(leaveDto);
        }
        return leaveDtos;
    }

    public Leave findById(String id){
        return leaveRepository.findById(Long.valueOf(id)).get();
    }
}
