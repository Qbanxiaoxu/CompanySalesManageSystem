package com.example.csms.mapper;


import com.example.csms.bean.OrderDetail;

import java.util.List;

public interface OrderDetailMapper {
    void addOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetails();
    OrderDetail findOrderDetail(int orderDetailId);
    OrderDetail deleteOrderDetailById(int orderDetailId);
    void modifyOrderDetail(OrderDetail orderDetail);
    List<OrderDetail> queryOrderDetails();
}
