package com.SSU.ShkodinMax.repository;

import com.SSU.ShkodinMax.model.Product;
import com.SSU.ShkodinMax.model.Provider;

import java.util.List;

public interface ProviderDAO {
    Provider findById(int id) throws Exception;

    void save(Provider provider);

    void update(Provider provider);

    void delete(Provider provider);

    List<Provider> getAll();
}
