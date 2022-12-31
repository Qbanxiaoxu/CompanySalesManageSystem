package com.example.csms.controller;


import com.example.csms.bean.OrderDetail;
import com.example.csms.service.OrderDetailService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class OrderDetailController {
    @Resource
    private OrderDetailService orderDetailService;

    @RequestMapping(value = "/ModifyOrderDetail", name = "modify",method = RequestMethod.POST)
    @ResponseBody
    public void modifyOrderDetail(OrderDetail orderDetail){
        orderDetailService.modifyOrderDetail(orderDetail);
    }

    @RequestMapping(value = "/AddOrderDetail", name="add",method= RequestMethod.POST)
    @ResponseBody
    public String addOrderDetail(OrderDetail orderDetail){
        if (orderDetail==null)
            return "404.html";
        orderDetailService.addOrderDetail(orderDetail);
        return null;
    }

    /**
     * 查看产品销售
     *
     * @return {@link String}
     */
    @RequestMapping(value = "/CheckProductSales", name = "查看产品销售情况")
    public String viewProductSales(HttpServletRequest request){
        int productId= Integer.parseInt(request.getParameter("productId"));
        StringBuilder json=new StringBuilder();
        json.append("[");
        String jsonStr="";
        List<OrderDetail> orderDetails = orderDetailService.queryOrderDetails();
        long turnover=0;
        int productNum=0;
        for(OrderDetail orderDetail:orderDetails){
            if(orderDetail.getProductId()==productId) {
                turnover += orderDetail.getTotalPrice();
                productNum+=orderDetail.getProductNumber();
            }
        }
        json.append("{\"turnover\":");
        json.append(turnover);
        json.append("{\"productNumber\":");
        json.append(productNum);
        json.append("}");
        jsonStr=json.substring(0,json.length())+"]";
        return jsonStr;
    }
}
