package com.SSU.ShkodinMax.services;
;
import com.SSU.ShkodinMax.model.Client;

public interface ClientService {
   void addClient(Client client) throws Exception;

   void updateClient(Client client) throws Exception;

   void deleteClient(Client client) throws Exception;

   Client getClientById(int id) throws Exception;



}
