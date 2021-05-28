package com.SSU.ShkodinMax.services;

import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.model.Provider;

import java.util.List;

public interface ProviderService {
    void addProvider(Provider provider) throws Exception;

    void updateProvider(Provider provider) throws Exception;

    void deleteProvider(Provider provider) throws Exception;

    Provider getProviderById(int id) throws Exception;

    List<Provider> getAll();
}
