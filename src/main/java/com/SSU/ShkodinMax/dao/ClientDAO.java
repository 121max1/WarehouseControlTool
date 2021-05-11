package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Client;

public interface ClientDAO {
    Client findById(int id) throws Exception;

    void save(Client client) throws Exception;

    void update(Client client) throws Exception;

    void delete(Client client) throws Exception;

}
