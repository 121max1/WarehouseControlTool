package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.services.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public  class ClientIOHelper {

    public static void addClient(ClientService clientService) throws Exception {
        Scanner sc = new Scanner(System.in);

        Client clientToReturn = new Client();
        System.out.print("Enter Fullname:");
        clientToReturn.setFullName(sc.nextLine());
        System.out.print("Enter Address:");
        clientToReturn.setAddress(sc.nextLine());
        System.out.print("Enter Email:");
        clientToReturn.setEmail(sc.nextLine());
        System.out.print("Enter Phone number:");
        clientToReturn.setPhoneNumber(sc.nextLine());
        clientService.addClient(clientToReturn);
    }
    public static void deleteClient(ClientService clientService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id:");
        clientService.deleteClient(clientService.getClientById(sc.nextInt()));
    }
    public  static void updateClient(ClientService clientService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter client's id:");
        Client client = clientService.getClientById(sc.nextInt());
        System.out.print("Enter Fullname:");
        client.setFullName(sc.nextLine());
        System.out.print("Enter Address:");
        client.setAddress(sc.nextLine());
        System.out.print("Enter Email:");
        client.setEmail(sc.nextLine());
        System.out.print("Enter Phone number:");
        client.setPhoneNumber(sc.nextLine());
        clientService.updateClient(client);
    }
    public static void getALl(ClientService clientService) throws JsonProcessingException {
        for(Client client : clientService.getAll()){
            String serialized = new ObjectMapper().writeValueAsString(client);
            System.out.println(serialized);
        }
    }


}
