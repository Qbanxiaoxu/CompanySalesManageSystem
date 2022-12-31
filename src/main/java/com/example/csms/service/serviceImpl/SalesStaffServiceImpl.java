package com.example.csms.service.serviceImpl;

import com.example.csms.bean.SalesStaff;
import com.example.csms.service.SalesStaffService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesStaffServiceImpl implements SalesStaffService {
    @Resource
    private com.example.csms.mapper.SalesStaffMapper SalesStaffMapper;
    public void addSalesStaff(SalesStaff SalesStaff){
        SalesStaffMapper.addSalesStaff(SalesStaff);
    }

    public void deleteSalesStaff(int SalesStaffId){
        SalesStaffMapper.deleteSalesStaff(SalesStaffId);
    }

    public SalesStaff findSalesStaffById(int SalesStaffId){
        return SalesStaffMapper.findSalesStaffById(SalesStaffId);
    }
    public SalesStaff verifySalesStaff(String username, String password){
        return SalesStaffMapper.findSalesStaff(username,password);
    }

    public void modifySalesStaff(SalesStaff SalesStaff){
        SalesStaffMapper.modifySalesStaff(SalesStaff);
    }

    public List<SalesStaff> querySalesStaffs(){
        return SalesStaffMapper.querySalesStaffs();
    }
}
