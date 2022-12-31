package com.example.csms.controller;


import com.example.csms.bean.SalesStaff;
import com.example.csms.service.SalesStaffService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class TakeOrderController {
    @Autowired
    private RestTemplate restTemplate;
    private SalesStaffService salesStaffService;

    @RequestMapping(value = "/CheckTakeOrders",name = "查看接单信息")
    public String viewTakeOrdersInfo(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        SalesStaff salesStaff = salesStaffService.verifySalesStaff(username, password);
        if (salesStaff == null) return "404.html";
        long salesStaffId = salesStaff.getSalesStaffId();

        String url="http://orderserver/order/query";
        String ordersJson=restTemplate.getForObject(url,String.class);
        //TODO
        //StringBuilder json = new StringBuilder();
        //json.append("[");
        //String jsonStr = "";
        //for (Order order : orders) {
        //    if (order.getClientId() == salesStaffId) {
        //        json.append("{\"orderId\":");
        //        json.append(order.getOrderId());
        //        json.append(",\"orderTime\":\"");
        //        json.append(order.getOrderTime());
        //        json.append("\",\"clientId\":");
        //        json.append(order.getClientId());
        //        json.append(",\"salesStaffId\":");
        //        json.append(order.getSalesStaffId());
        //        json.append(",\"consumption\":");
        //        json.append(order.getConsumption());
        //        json.append("},");
        //    }
        //}
        //jsonStr = json.substring(0, json.length() - 1) + "]";
        return "jsonStr";
    }
}
