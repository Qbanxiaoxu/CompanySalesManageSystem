package com.example.csms.controller;


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
        //TODO

        //List<Order> orders = orderService.queryOrders();
        //StringBuilder json = new StringBuilder();
        //json.append("[");
        //String jsonStr = "";
        //for (Order order : orders) {
        //    if (order.getClientId() == clientId) {
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
