package com.example.csms.mapper;


import com.example.csms.bean.SalesStaff;

import java.util.List;

public interface SalesStaffMapper {
    void addSalesStaff(SalesStaff salesStaff);
    void deleteSalesStaff(int salesStaffId);
    SalesStaff findSalesStaff(String username, String password);
    SalesStaff findSalesStaffById(int salesStaffId);
    void modifySalesStaff(SalesStaff salesStaff);
    List<SalesStaff> querySalesStaffs();
}
