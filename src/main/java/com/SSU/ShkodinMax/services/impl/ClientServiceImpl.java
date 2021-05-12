package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.dao.ClientDAO;
import com.SSU.ShkodinMax.dao.impl.ClientDAOImpl;
import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.services.ClientService;

public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO;

    public ClientServiceImpl(){
        clientDAO = new ClientDAOImpl();
    }

    @Override
    public void addClient(Client client) throws Exception {
        clientDAO.save(client);
    }

    @Override
    public void updateClient(Client client) throws Exception {
        clientDAO.update(client);
    }

    @Override
    public void deleteClient(Client client) throws Exception {
        clientDAO.delete(client);
    }

    @Override
    public Client getClientById(int id) throws Exception {
        return  clientDAO.findById(id);
    }
}
