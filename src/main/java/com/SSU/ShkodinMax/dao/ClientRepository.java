package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Client;

import java.util.List;

public interface ClientRepository {
    Client findById(int id) throws Exception;

    void save(Client client);

    void update(Client client);

    void delete(Client client);

    List<Client> getAll();

}
