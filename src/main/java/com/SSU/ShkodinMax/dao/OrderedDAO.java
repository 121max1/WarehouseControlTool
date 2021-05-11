package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Ordered;

public interface OrderedDAO {
    Ordered findById(int id);

    void save(Ordered ordered);

    void update(Ordered ordered);

    void delete(Ordered ordered);
}
