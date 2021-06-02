package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.dao.OrderRepository;
import com.SSU.ShkodinMax.dao.impl.OrderRepositoryImpl;
import com.SSU.ShkodinMax.model.Order;
import com.SSU.ShkodinMax.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    public OrderServiceImpl(){
        orderRepository = new OrderRepositoryImpl();
    }

    @Override
    public void addOrder(Order order) throws Exception {
        orderRepository.save(order);

    }

    @Override
    public void updateOrder(Order order) throws Exception {
        orderRepository.update(order);
    }

    @Override
    public void deleteOrder(Order order) throws Exception {
        orderRepository.delete(order);
    }

    @Override
    public Order getOrderById(int id) throws Exception {
        return orderRepository.findById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderRepository.getAll();
    }
}
