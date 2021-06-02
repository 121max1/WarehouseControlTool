package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.dao.ClientRepository;
import com.SSU.ShkodinMax.dao.impl.ClientRepositoryImpl;
import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.services.ClientService;

import java.util.List;

public class ClientServiceImpl implements ClientService {

    private ClientRepository clientRepository;

    public ClientServiceImpl(){
        clientRepository = new ClientRepositoryImpl();
    }

    @Override
    public void addClient(Client client) {
        clientRepository.save(client);
    }

    @Override
    public void updateClient(Client client) throws Exception {
        clientRepository.update(client);
    }

    @Override
    public void deleteClient(Client client) throws Exception {
        clientRepository.delete(client);
    }

    @Override
    public Client getClientById(int id) throws Exception {
        return  clientRepository.findById(id);
    }

    @Override
    public List<Client> getAll() {
        return clientRepository.getAll();
    }
}
