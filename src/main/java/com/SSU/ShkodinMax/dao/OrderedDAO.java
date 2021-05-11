package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Ordered;

public interface OrderedDAO {
    Ordered findByIdProduct(int id) throws Exception;

    void save(Ordered ordered) throws Exception;

    void update(Ordered ordered) throws Exception;

    void delete(Ordered ordered) throws Exception;
}
