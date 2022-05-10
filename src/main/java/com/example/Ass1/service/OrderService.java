package com.example.Ass1.service;

import com.example.Ass1.entity.OrderModel;

import java.util.List;

public interface OrderService {


    OrderModel saveOrder(OrderModel order);
    List<OrderModel> getAllOrders();
    OrderModel getOrderById(long id);
    OrderModel updateOrder(OrderModel order, long id);
    void deleteOrder(long id);
}
