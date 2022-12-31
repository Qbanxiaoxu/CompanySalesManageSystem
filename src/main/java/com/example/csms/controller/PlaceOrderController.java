package com.example.csms.controller;


import com.example.csms.bean.OrderDetail;
import com.example.csms.bean.Product;
import com.example.csms.service.GetService;
import com.example.csms.service.OrderDetailService;
import com.example.csms.service.ProductService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.sql.Timestamp;
import java.util.Date;

@Controller
public class PlaceOrderController {
    @Autowired
    private RestTemplate restTemplate;
    @Resource
    private OrderDetailService orderDetailService;
    @Resource
    private ProductService productService;
    @Resource
    private GetService getService;


    @RequestMapping(value = "/PlaceOrderDetail", name = "生成订单明细")
    public void placeOrderDetail(HttpServletRequest request){
        int productId= Integer.parseInt(request.getParameter("productId"));
        int productNum= Integer.parseInt(request.getParameter("productNum"));
        int orderDetailId=0;
        Product product=productService.findProduct(productId);
        long totalPrice= (long) (productNum*product.getProductPrice());
        OrderDetail orderDetail=new OrderDetail(orderDetailId,productId,productNum,totalPrice);
        orderDetailService.addOrderDetail(orderDetail);
        placeOrder(totalPrice);
    }

    /**
     * 下订单
     *
     * @param consumption 消费
     *///@RequestMapping(value = "/PlaceOrder", name = "生成订单")
    public void placeOrder(long consumption){
        int orderId=0;
        Date date = new Date();
        Timestamp orderTime = new Timestamp(date.getTime());

        int clientId=(int)(1+Math.random()*(getService.getClientsNumber()-1+1));
        int salesStaffId=(int)(1+Math.random()*(getService.getSalesStaffsNumber()-1+1));
        String url="http://orderserver/add/"+orderId+"/"+orderTime+"/"+clientId+"/"+salesStaffId+"/"+consumption;
        restTemplate.getForObject(url,String.class);
    }

}
