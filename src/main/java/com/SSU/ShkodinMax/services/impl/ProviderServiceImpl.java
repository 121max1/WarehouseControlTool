package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.repository.ProviderDAO;
import com.SSU.ShkodinMax.repository.impl.ProviderDAOImpl;
import com.SSU.ShkodinMax.model.Provider;
import com.SSU.ShkodinMax.services.ProviderService;

import java.util.List;

public class ProviderServiceImpl implements ProviderService {

    private ProviderDAO providerDAO;

    public ProviderServiceImpl(){
        providerDAO = new ProviderDAOImpl();
    }


    @Override
    public void addProvider(Provider provider) throws Exception {
        providerDAO.save(provider);
    }

    @Override
    public void updateProvider(Provider provider) throws Exception {
        providerDAO.update(provider);
    }

    @Override
    public void deleteProvider(Provider provider) throws Exception {
        providerDAO.delete(provider);
    }

    @Override
    public Provider getProviderById(int id) throws Exception {
        return providerDAO.findById(id);
    }

    @Override
    public List<Provider> getAll() {
        return providerDAO.getAll();
    }
}
