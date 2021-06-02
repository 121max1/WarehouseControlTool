package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.dao.ProviderRepository;
import com.SSU.ShkodinMax.dao.impl.ProviderRepositoryImpl;
import com.SSU.ShkodinMax.model.Provider;
import com.SSU.ShkodinMax.services.ProviderService;

import java.util.List;

public class ProviderServiceImpl implements ProviderService {

    private ProviderRepository providerRepository;

    public ProviderServiceImpl(){
        providerRepository = new ProviderRepositoryImpl();
    }


    @Override
    public void addProvider(Provider provider) throws Exception {
        providerRepository.save(provider);
    }

    @Override
    public void updateProvider(Provider provider) throws Exception {
        providerRepository.update(provider);
    }

    @Override
    public void deleteProvider(Provider provider) throws Exception {
        providerRepository.delete(provider);
    }

    @Override
    public Provider getProviderById(int id) throws Exception {
        return providerRepository.findById(id);
    }

    @Override
    public List<Provider> getAll() {
        return providerRepository.getAll();
    }
}
