package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Type;

public interface TypeDAO {
    Type findById(int id) throws Exception;

    void save(Type type) throws Exception;

    void update(Type type) throws Exception;

    void delete(Type type) throws Exception;
}
