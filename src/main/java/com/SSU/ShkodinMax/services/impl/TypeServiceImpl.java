package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.dao.TypeDAO;
import com.SSU.ShkodinMax.dao.impl.TypeDAOImpl;
import com.SSU.ShkodinMax.model.Type;
import com.SSU.ShkodinMax.services.TypeService;

public class TypeServiceImpl implements TypeService {

    private TypeDAO typeDAO;

    public  TypeServiceImpl(){
        typeDAO = new TypeDAOImpl();
    }

    @Override
    public void addType(Type type) throws Exception {
        typeDAO.save(type);
    }

    @Override
    public void updateType(Type type) throws Exception {
        typeDAO.update(type);

    }

    @Override
    public void deleteType(Type type) throws Exception {
        typeDAO.delete(type);

    }

    @Override
    public Type getTypeById(int id) throws Exception {
        return typeDAO.findById(id);
    }
}
