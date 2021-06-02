package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.dao.TypeRepository;
import com.SSU.ShkodinMax.dao.impl.TypeRepositoryImpl;
import com.SSU.ShkodinMax.model.Type;
import com.SSU.ShkodinMax.services.TypeService;

import java.util.List;

public class TypeServiceImpl implements TypeService {

    private TypeRepository typeRepository;

    public  TypeServiceImpl(){
        typeRepository = new TypeRepositoryImpl();
    }

    @Override
    public void addType(Type type) throws Exception {
        typeRepository.save(type);
    }

    @Override
    public void updateType(Type type) throws Exception {
        typeRepository.update(type);

    }

    @Override
    public void deleteType(Type type) throws Exception {
        typeRepository.delete(type);

    }

    @Override
    public Type getTypeById(int id) throws Exception {
        return typeRepository.findById(id);
    }

    @Override
    public List<Type> getAll() {
        return typeRepository.getAll();
    }
}
