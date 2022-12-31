package com.example.csms.service;


import com.example.csms.bean.OrderDetail;

import java.util.List;

public interface OrderDetailService {
    void addOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetails();
    void deleteOrderDetailById(int orderDetailId);
    OrderDetail findOrderDetail(int orderDetailId);
    void modifyOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> queryOrderDetails();
}
