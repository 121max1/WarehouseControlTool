package com.SSU.ShkodinMax.services;

import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.model.Type;

import java.util.List;

public interface TypeService {
    void addType(Type type) throws Exception;

    void updateType(Type type) throws Exception;

    void deleteType(Type type) throws Exception;

    Type getTypeById(int id) throws Exception;

    List<Type> getAll();

}
