package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.services.ClientService;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;


public  class ClientIOHelper {

    public static void addClient(ClientService clientService) throws Exception {
        //try {
            Client clientToReturn = new Client();
            System.out.print("Enter client's fullname:");
            clientToReturn.setFullName(ConsoleInputHelper.enterString());
            System.out.print("Enter client's address:");
            clientToReturn.setAddress(ConsoleInputHelper.enterString());
            System.out.print("Enter client's email:");
            clientToReturn.setEmail(ConsoleInputHelper.enterString());
            System.out.print("Enter client's phone number:");
            clientToReturn.setPhoneNumber(ConsoleInputHelper.enterString());
            System.out.print("Enter client's note:");
            clientToReturn.setNote(ConsoleInputHelper.enterString());
            clientService.addClient(clientToReturn);
            System.out.println("Success! Client added");
        //}
        //catch (Exception e){
          //  System.out.println("Something went wrong. Reason: " + e.getMessage());
        //}
    }
    public static void deleteClient(ClientService clientService) {
        try {
            System.out.print("Enter id:");
            int id = ConsoleInputHelper.enterPositiveIntValue();
            if (ConsoleInputHelper.getConfirmationMessageResult()) {
                clientService.deleteClient(clientService.getClientById(id));
                System.out.println("Success! Client deleted");
            }else{
                System.out.println("Operation canceled");
            }
        }catch(Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }

    }
    public  static void updateClient(ClientService clientService) {
        try {
            System.out.print("Enter client's id:");
            Client client = clientService.getClientById(ConsoleInputHelper.enterPositiveIntValue());
            System.out.print("Enter client's fullname:");
            client.setFullName(ConsoleInputHelper.enterString());
            System.out.print("Enter client's address:");
            client.setAddress(ConsoleInputHelper.enterString());
            System.out.print("Enter client's email:");
            client.setEmail(ConsoleInputHelper.enterString());
            System.out.print("Enter client's phone number:");
            client.setPhoneNumber(ConsoleInputHelper.enterString());
            System.out.print("Enter client's note:");
            client.setNote(ConsoleInputHelper.enterString());
            if (ConsoleInputHelper.getConfirmationMessageResult()) {
                System.out.println("Success! Client updated");
                clientService.updateClient(client);
            }else{
                System.out.println("Operation canceled");
            }
            clientService.updateClient(client);
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void getALl(ClientService clientService) {
        try{
        for(Client client : clientService.getAll()){
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println( mapper.writeValueAsString(client));
        } }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }



}
