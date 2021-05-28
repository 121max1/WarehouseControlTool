package com.SSU.ShkodinMax.services;


import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.model.Ordered;

import java.util.List;

public interface OrderedService {
    void addOrdered(Ordered ordered) throws Exception;

    void updateOrdered(Ordered ordered) throws Exception;

    void deleteOrdered(Ordered ordered) throws Exception;

    Ordered getOrderedById(int id) throws Exception;

    List<Ordered> getAll();
}
