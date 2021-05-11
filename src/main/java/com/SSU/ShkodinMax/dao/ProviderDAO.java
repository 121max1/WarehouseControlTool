package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Provider;

public interface ProviderDAO {
    Provider findById(int id) throws Exception;

    void save(Provider provider) throws Exception;

    void update(Provider provider) throws Exception;

    void delete(Provider provider) throws Exception;
}
