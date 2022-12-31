package com.example.csms.controller;

import com.example.csms.bean.SalesStaff;
import com.example.csms.service.SalesStaffService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SalesStaffController {
    @Resource
    private SalesStaffService salesStaffService;


    @RequestMapping(value = "/ModifySalesStaff", name = "modify",method = RequestMethod.POST)
    @ResponseBody
    public void modify(SalesStaff salesStaff){
        salesStaffService.modifySalesStaff(salesStaff);
    }

    @RequestMapping(value = "/AddSalesStaff", name="add",method= RequestMethod.POST)
    public String addCSalesStaff(SalesStaff salesStaff){
        if (salesStaff==null)
            return "404.html";
        salesStaffService.addSalesStaff(salesStaff);
        return null;
    }
}
