package com.SSU.ShkodinMax.services;

import com.SSU.ShkodinMax.model.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order) throws Exception;

    void updateOrder(Order order) throws Exception;

    void deleteOrder(Order order) throws Exception;

    Order getOrderById(int id) throws Exception;

    List<Order> getAll();

}
