package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.services.ClientService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public  class ClientIOHelper {

    public static void addClient(ClientService clientService) {
        try {
            Scanner sc = new Scanner(System.in);
            Client clientToReturn = new Client();
            System.out.print("Enter client's fullname:");
            clientToReturn.setFullName(sc.nextLine());
            System.out.print("Enter client's address:");
            clientToReturn.setAddress(sc.nextLine());
            System.out.print("Enter client's email:");
            clientToReturn.setEmail(sc.nextLine());
            System.out.print("Enter client's number:");
            clientToReturn.setPhoneNumber(sc.nextLine());
            System.out.print("Enter client's note:");
            clientToReturn.setNote(sc.nextLine());
            clientService.addClient(clientToReturn);
            System.out.println("Success! Client added");
        }
        catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void deleteClient(ClientService clientService) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id:");
            clientService.deleteClient(clientService.getClientById(sc.nextInt()));
            System.out.println("Success! Client deleted");
        }catch(Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }

    }
    public  static void updateClient(ClientService clientService) {
        try {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter client's id:");
            Client client = clientService.getClientById(sc.nextInt());
            System.out.print("Enter client's fullname:");
            client.setFullName(sc.nextLine());
            System.out.print("Enter client's address:");
            client.setAddress(sc.nextLine());
            System.out.print("Enter client's email:");
            client.setEmail(sc.nextLine());
            System.out.print("Enter client's phone number:");
            client.setPhoneNumber(sc.nextLine());
            System.out.print("Enter client's note:");
            client.setNote(sc.nextLine());
            clientService.updateClient(client);
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void getALl(ClientService clientService) {
        try{
        for(Client client : clientService.getAll()){
            String serialized = new ObjectMapper().writeValueAsString(client);
            System.out.println(serialized);
        } }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }


}
