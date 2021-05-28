package com.SSU.ShkodinMax.repository;

import com.SSU.ShkodinMax.model.Client;

import java.util.List;

public interface ClientDAO {
    Client findById(int id);

    void save(Client client);

    void update(Client client);

    void delete(Client client);

    List<Client> getAll();

}
