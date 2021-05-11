package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Order;

public interface OrderDAO {
    Order findById(int id);

    void save(Order order);

    void update(Order order);

    void delete(Order order);
}
