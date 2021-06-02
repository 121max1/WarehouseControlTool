package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.dao.OrderedRepository;
import com.SSU.ShkodinMax.dao.impl.OrderedRepositoryImpl;
import com.SSU.ShkodinMax.model.Ordered;
import com.SSU.ShkodinMax.services.OrderedService;

import java.util.List;

public class OrderedServiceImpl implements OrderedService {

    private OrderedRepository orderedRepository;

    public OrderedServiceImpl(){
        orderedRepository = new OrderedRepositoryImpl();
    }

    @Override
    public void addOrdered(Ordered ordered) throws Exception {
        orderedRepository.save(ordered);
    }

    @Override
    public void updateOrdered(Ordered ordered) throws Exception {
        orderedRepository.update(ordered);
    }

    @Override
    public void deleteOrdered(Ordered ordered) throws Exception {
        orderedRepository.delete(ordered);
    }

    @Override
    public Ordered getOrderedById(int id) throws Exception {
        return orderedRepository.findById(id);
    }

    @Override
    public List<Ordered> getAll() {
        return orderedRepository.getAll();
    }
}
