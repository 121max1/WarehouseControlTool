package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Client;

public interface ClientDAO {
    Client findById(int id);

    void save(Client client);

    void update(Client client);

    void delete(Client client);

}
