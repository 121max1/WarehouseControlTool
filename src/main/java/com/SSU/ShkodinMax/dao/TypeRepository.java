package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Type;

import java.util.List;

public interface TypeRepository {
    Type findById(int id) throws Exception;

    void save(Type type);

    void update(Type type);

    void delete(Type type);

    List<Type> getAll();
}
