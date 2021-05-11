package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Type;

public interface TypeDAO {
    Type findById(int id);

    void save(Type type);

    void update(Type type);

    void delete(Type type);
}
