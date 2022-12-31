package com.example.csms.controller;


import com.example.csms.bean.Administrator;
import com.example.csms.bean.Client;
import com.example.csms.bean.SalesStaff;
import com.example.csms.service.AdministratorService;
import com.example.csms.service.ClientService;
import com.example.csms.service.SalesStaffService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PersonalInfoController {
    @Resource
    private AdministratorService administratorService;
    @Resource
    private ClientService clientService;
    @Resource
    private SalesStaffService salesStaffService;


    @RequestMapping(value = "/PersonalInfo", name = "personal info")
    @ResponseBody
    public String findByInfo(HttpServletRequest request) {

        String object = request.getParameter("object");
        String username=request.getParameter("username");
        String password=request.getParameter("password");
        //System.out.println(object+"\n"+username+"\n"+password);
        StringBuilder json = new StringBuilder();
        json.append("[");
        String jsonStr = "";
        if (object.equals("Administrator")) {
            Administrator administrator = administratorService.verifyAdministrator(username,password);
            json.append("{\"administratorId\":");
            json.append(administrator.getAdministratorId());
            json.append(",\"administratorPassword\":\"");
            json.append(administrator.getAdministratorPassword());
            json.append("\",\"administratorName\":\"");
            json.append(administrator.getAdministratorName());
            json.append("\",\"administratorGender\":\"");
            json.append(administrator.getAdministratorGender());
            json.append("\",\"administratorAddress\":\"");
            json.append(administrator.getAdministratorAddress());
            json.append("\",\"administratorEmail\":\"");
            json.append(administrator.getAdministratorEmail());
            json.append("\"},");
            jsonStr = json.substring(0, json.length() - 1) + "]";
            //System.out.println(administrator.getAdministratorGender());
            return jsonStr;
        }
        if (object.equals("Client")) {
            Client client = clientService.verifyClient(username,password);

            json.append("{\"clientId\":");
            json.append(client.getClientId());
            json.append(",\"clientPassword\":\"");
            json.append(client.getClientPassword());
            json.append("\",\"clientName\":\"");
            json.append(client.getClientName());
            json.append("\",\"clientGender\":\"");
            json.append(client.getClientGender());
            json.append("\",\"clientAddress\":\"");
            json.append(client.getClientAddress());
            json.append("\",\"clientEmail\":\"");
            json.append(client.getClientEmail());
            json.append("\"},");
            jsonStr = json.substring(0, json.length() - 1) + "]";
            return jsonStr;
        }
        if (object.equals("SalesStaff")) {
            SalesStaff salesStaff = salesStaffService.verifySalesStaff(username,password);

            json.append("{\"salesStaffId\":");
            json.append(salesStaff.getSalesStaffId());
            json.append(",\"salesStaffPassword\":\"");
            json.append(salesStaff.getSalesStaffPassword());
            json.append("\",\"salesStaffName\":\"");
            json.append(salesStaff.getSalesStaffName());
            json.append("\",\"salesStaffGender\":\"");
            json.append(salesStaff.getSalesStaffGender());
            json.append("\",\"salesStaffAddress\":\"");
            json.append(salesStaff.getSalesStaffAddress());
            json.append("\",\"salesStaffEmail\":\"");
            json.append(salesStaff.getSalesStaffEmail());
            json.append("\",\"salesStaffSalary\":");
            json.append(salesStaff.getSalesStaffSalary());
            json.append("},");

            jsonStr = json.substring(0, json.length() - 1) + "]";
            return jsonStr;
        }
        return "404.html";
    }
}
