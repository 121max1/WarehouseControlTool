package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.repository.OrderDAO;
import com.SSU.ShkodinMax.repository.impl.OrderDAOImpl;
import com.SSU.ShkodinMax.model.Order;
import com.SSU.ShkodinMax.services.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;

    public OrderServiceImpl(){
        orderDAO = new OrderDAOImpl();
    }

    @Override
    public void addOrder(Order order) throws Exception {
        orderDAO.save(order);

    }

    @Override
    public void updateOrder(Order order) throws Exception {
        orderDAO.update(order);
    }

    @Override
    public void deleteOrder(Order order) throws Exception {
        orderDAO.delete(order);
    }

    @Override
    public Order getOrderById(int id) throws Exception {
        return orderDAO.findById(id);
    }

    @Override
    public List<Order> getAll() {
        return orderDAO.getAll();
    }
}
