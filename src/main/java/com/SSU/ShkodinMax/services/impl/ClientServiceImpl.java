package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.repository.ClientDAO;
import com.SSU.ShkodinMax.repository.impl.ClientDAOImpl;
import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientDAO clientDAO;

    public ClientServiceImpl(){
        clientDAO = new ClientDAOImpl();
    }

    @Override
    public void addClient(Client client) {
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

    @Override
    public List<Client> getAll() {
        return clientDAO.getAll();
    }
}
