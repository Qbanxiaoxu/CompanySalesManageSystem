package com.example.orderserver.mapper;


import com.example.orderserver.bean.Order;

import java.util.List;

public interface OrderMapper {
    void addOrder(Order order);
    void deleteOrder(int orderId);
    Order findOrder(int orderId);
    void modifyOrder(Order order);
    List<Order> queryOrders();
}
