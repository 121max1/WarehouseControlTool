package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Order;

import java.util.List;

public interface OrderRepository {
    Order findById(int id) throws Exception;

    void save(Order order);

    void update(Order order);

    void delete(Order order);

    List<Order> getAll();
}
