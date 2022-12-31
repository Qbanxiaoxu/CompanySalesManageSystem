package com.example.csms.service;


import com.example.csms.bean.SalesStaff;

import java.util.List;

public interface SalesStaffService {
    List<SalesStaff> querySalesStaffs();
    SalesStaff verifySalesStaff(String username,String password);
    void addSalesStaff(SalesStaff salesStaff);
    void deleteSalesStaff(int salesStaffId);
    SalesStaff findSalesStaffById(int salesStaffId);
    void modifySalesStaff(SalesStaff salesStaff);
}
