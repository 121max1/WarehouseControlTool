package com.SSU.ShkodinMax.services;
;
import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.model.Type;

import java.util.List;

public interface ClientService {
   void addClient(Client client) throws Exception;

   void updateClient(Client client) throws Exception;

   void deleteClient(Client client) throws Exception;

   Client getClientById(int id) throws Exception;

   List<Client> getAll();


}
