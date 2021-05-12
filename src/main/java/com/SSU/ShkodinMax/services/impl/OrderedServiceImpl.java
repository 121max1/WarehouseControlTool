package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.dao.OrderedDAO;
import com.SSU.ShkodinMax.dao.impl.OrderedDAOImpl;
import com.SSU.ShkodinMax.model.Ordered;
import com.SSU.ShkodinMax.services.OrderedService;

public class OrderedServiceImpl implements OrderedService {

    private OrderedDAO orderedDAO;

    public OrderedServiceImpl(){
        orderedDAO = new OrderedDAOImpl();
    }

    @Override
    public void addOrdered(Ordered ordered) throws Exception {
        orderedDAO.save(ordered);
    }

    @Override
    public void updateOrdered(Ordered ordered) throws Exception {
        orderedDAO.update(ordered);
    }

    @Override
    public void deleteOrdered(Ordered ordered) throws Exception {
        orderedDAO.delete(ordered);
    }

    @Override
    public Ordered getOrderedById(int id) throws Exception {
        return orderedDAO.findByIdProduct(id);
    }
}
