package com.example.orderserver.controller;


import com.example.orderserver.bean.Order;
import com.example.orderserver.service.OrderService;
import com.google.gson.Gson;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class OrderServiceController {
    @Resource
    private OrderService orderService;

    @RequestMapping(value = "/order/add/{orderId}/{orderTime}/{clientId}/{salesStaffId}/{consumption}",name = "add")
    @ResponseBody
    public String add(@PathVariable int orderId, @PathVariable String orderTime, @PathVariable int clientId, @PathVariable int salesStaffId, @PathVariable long consumption){
        orderTime=orderTime+" 00:00:00";
        Timestamp timestamp= Timestamp.valueOf(orderTime);
        Order order=new Order(orderId,timestamp,clientId,salesStaffId,consumption);
        orderService.addOrder(order);
        return "订单添加成功";
    }

    @RequestMapping(value = "/order/delete/{orderId}",name = "delete")
    @ResponseBody
    public String delete(@PathVariable int orderId){
        orderService.deleteOrder(orderId);
        return "订单删除成功";
    }

    @RequestMapping(value = "/order/find/{orderId}",name = "find")
    @ResponseBody
    public String find(@PathVariable int orderId){
        Order order=orderService.findOrder(orderId);
        Gson gson = new Gson();
        return gson.toJson(order);
    }

    @RequestMapping(value = "/order/modify/{orderId}/{orderTime}/{clientId}/{salesStaffId}/{consumption}",name = "modify")
    @ResponseBody
    public String modify(@PathVariable int orderId, @PathVariable Timestamp orderTime, @PathVariable int clientId, @PathVariable int salesStaffId, @PathVariable long consumption){
        Order order=new Order(orderId,orderTime,clientId,salesStaffId,consumption);
        orderService.modifyOrder(order);
        return "订单修改成功";
    }

    @RequestMapping(value = "/order/query",name = "query")
    @ResponseBody
    public String query(){
        List<Order> orders=orderService.queryOrders();
        Gson gson=new Gson();
        return gson.toJson(orders);
    }
}
