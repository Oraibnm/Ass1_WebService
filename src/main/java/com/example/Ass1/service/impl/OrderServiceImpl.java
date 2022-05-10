package com.example.Ass1.service.impl;

import com.example.Ass1.entity.OrderModel;
import com.example.Ass1.exception.ResourceNotFoundException;
import com.example.Ass1.repository.OrderRepository;
import com.example.Ass1.service.OrderService;
import com.example.Ass1.service.SupplierService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;
    @Override
    public OrderModel saveOrder(OrderModel order) {
        return orderRepository.save(order);
    }

    @Override
    public List<OrderModel> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public OrderModel getOrderById(long id) {
        return orderRepository.findById(id).orElseThrow(()->
                new ResourceNotFoundException("Order", "Id", id));

    }

    @Override
    public OrderModel updateOrder(OrderModel order, long id) {
        OrderModel existingOrder = orderRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Order", "Id", id));

        existingOrder.setBuyer(order.getBuyer());
        existingOrder.setValue(order.getValue());
        existingOrder.setAddress(order.getAddress());
        existingOrder.setPhone(order.getPhone());

        orderRepository.save(existingOrder);
        return existingOrder;
    }

    @Override
    public void deleteOrder(long id) {
    // check whether order exist in a DB or not
        orderRepository.findById(id).orElseThrow(() ->
                new ResourceNotFoundException("Order", "Id", id));
        orderRepository.deleteById(id);
    }
}
