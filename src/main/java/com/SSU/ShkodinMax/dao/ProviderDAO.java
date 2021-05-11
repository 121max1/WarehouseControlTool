package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Provider;

public interface ProviderDAO {
    Provider findById(int id);

    void save(Provider provider);

    void update(Provider provider);

    void delete(Provider provider);
}
