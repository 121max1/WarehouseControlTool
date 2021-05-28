package com.SSU.ShkodinMax.repository;

import com.SSU.ShkodinMax.model.Product;
import com.SSU.ShkodinMax.model.Type;

import java.util.List;

public interface TypeDAO {
    Type findById(int id);

    void save(Type type);

    void update(Type type);

    void delete(Type type);

    List<Type> getAll();
}
