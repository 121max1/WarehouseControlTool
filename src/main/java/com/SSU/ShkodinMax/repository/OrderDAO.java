package com.SSU.ShkodinMax.repository;

import com.SSU.ShkodinMax.model.Order;

import java.util.List;

public interface OrderDAO {
    Order findById(int id) ;

    void save(Order order);

    void update(Order order);

    void delete(Order order);

    List<Order> getAll();
}
