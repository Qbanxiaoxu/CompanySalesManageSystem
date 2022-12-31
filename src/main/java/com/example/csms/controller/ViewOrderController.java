package com.example.csms.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.example.csms.bean.Client;
import com.example.csms.service.ClientService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

@Controller
public class ViewOrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private ClientService clientService;

    /**
     * 查看订单信息
     *
     * @return {@link String}
     */
    @RequestMapping(value = "/QueryClientOrders", name = "查看与自己相关订单信息")
    @ResponseBody
    public String viewOrdersInfo(HttpServletRequest request) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        Client client = clientService.verifyClient(username, password);
        if (client == null) return "404.html";
        long clientId = client.getClientId();
        String url="http://orderserver/order/query";
        String ordersJson=restTemplate.getForObject(url,String.class);
        JSONArray orders= JSONArray.parseArray(ordersJson);
        //TODO

        //List<Order> orders = orderService.queryOrders();
        StringBuilder json = new StringBuilder();
        json.append("[");
        String jsonStr = "";
        if (ordersJson != null) {
            for(int i=0;i<orders.size();i++){
                String obj=orders.get(i).toString();
                JSONObject order=JSONObject.parseObject(obj);
                if(order.getInteger("clientId") == clientId){
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
        //System.out.println(json);
        jsonStr = json.substring(0, json.length() - 1) + "]";
        return jsonStr;
    }
}
