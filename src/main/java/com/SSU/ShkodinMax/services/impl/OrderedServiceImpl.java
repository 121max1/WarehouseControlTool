package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.repository.OrderedDAO;
import com.SSU.ShkodinMax.repository.impl.OrderedDAOImpl;
import com.SSU.ShkodinMax.model.Ordered;
import com.SSU.ShkodinMax.services.OrderedService;

import java.util.List;

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
        return orderedDAO.findById(id);
    }

    @Override
    public List<Ordered> getAll() {
        return orderedDAO.getAll();
    }
}
