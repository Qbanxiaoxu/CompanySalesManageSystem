package com.example.orderserver.service.serviceImpl;



import com.example.orderserver.bean.Order;
import com.example.orderserver.mapper.OrderMapper;
import com.example.orderserver.service.OrderService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;
    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }

    @Override
    public void deleteOrder(int orderId) {
        orderMapper.deleteOrder(orderId);
    }

    @Override
    public Order findOrder(int orderId) {
        return orderMapper.findOrder(orderId);
    }

    @Override
    public void modifyOrder(Order order) {
        orderMapper.modifyOrder(order);
    }

    @Override
    public List<Order> queryOrders() {
        return orderMapper.queryOrders();
    }
}
