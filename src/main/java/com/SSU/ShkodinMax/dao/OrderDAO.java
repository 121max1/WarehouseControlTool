package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Order;

public interface OrderDAO {
    Order findById(int id) throws Exception;

    void save(Order order) throws Exception;

    void update(Order order) throws Exception;

    void delete(Order order) throws Exception;
}
