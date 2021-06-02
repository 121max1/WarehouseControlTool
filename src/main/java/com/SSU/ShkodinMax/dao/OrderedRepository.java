package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Ordered;

import java.util.List;

public interface OrderedRepository {
    Ordered findById(int id) throws Exception;

    void save(Ordered ordered);

    void update(Ordered ordered);

    void delete(Ordered ordered);

    List<Ordered> getAll();
}
