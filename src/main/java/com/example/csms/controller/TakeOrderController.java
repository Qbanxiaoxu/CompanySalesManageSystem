package com.example.csms.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.csms.bean.SalesStaff;
import com.example.csms.service.SalesStaffService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class TakeOrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private SalesStaffService salesStaffService;

    @RequestMapping(value = "/CheckTakeOrders",name = "查看接单信息")
    @ResponseBody
    public String viewTakeOrdersInfo(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        SalesStaff salesStaff = salesStaffService.verifySalesStaff(username, password);
        if (salesStaff == null) return "404.html";
        long salesStaffId = salesStaff.getSalesStaffId();

        String url="http://orderserver/order/query";
        String ordersJson=restTemplate.getForObject(url,String.class);
        JSONArray orders= JSONArray.parseArray(ordersJson);
        //TODO
        StringBuilder json = new StringBuilder();
        json.append("[");
        String jsonStr = "";
        if (ordersJson != null) {
            for(int i=0;i<orders.size();i++){
                String obj=orders.get(i).toString();
                JSONObject order=JSONObject.parseObject(obj);
                if(order.getInteger("salesStaffId") == salesStaffId){
                    json.append("{\"orderId\":");
                    json.append(order.getInteger("orderId"));
                    json.append(",\"orderTime\":\"");
                    json.append(order.getString("orderTime"));
                    json.append("\",\"clientId\":");
                    json.append(order.getInteger("orderId"));
                    json.append(",\"salesStaffId\":");
                    json.append(order.getInteger("salesStaffId"));
                    json.append(",\"consumption\":");
                    json.append(order.getDouble("consumption"));
                    json.append("},");
                }
            }
        }
        jsonStr = json.substring(0, json.length() - 1) + "]";
        return jsonStr;
    }
}
