package com.example.csms.service.serviceImpl;

import com.example.csms.bean.OrderDetail;
import com.example.csms.mapper.OrderDetailMapper;
import com.example.csms.service.OrderDetailService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {
    @Resource
    private OrderDetailMapper orderDetailMapper;
    public void addOrderDetail(OrderDetail OrderDetail){
        orderDetailMapper.addOrderDetail(OrderDetail);
    }

    public void deleteOrderDetails(){
        orderDetailMapper.deleteOrderDetails();
    }
    public void deleteOrderDetailById(int orderDetailId){
        orderDetailMapper.deleteOrderDetailById(orderDetailId);
    }
    public OrderDetail findOrderDetail(int orderDetailId){
        return orderDetailMapper.findOrderDetail(orderDetailId);
    }
    public void modifyOrderDetail(OrderDetail orderDetail){
        orderDetailMapper.modifyOrderDetail(orderDetail);
    }

    public List<OrderDetail> queryOrderDetails(){
        return orderDetailMapper.queryOrderDetails();
    }

}
