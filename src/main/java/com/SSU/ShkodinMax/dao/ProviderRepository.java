package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Provider;

import java.util.List;

public interface ProviderRepository {
    Provider findById(int id) throws Exception;

    void save(Provider provider);

    void update(Provider provider);

    void delete(Provider provider);

    List<Provider> getAll();
}
