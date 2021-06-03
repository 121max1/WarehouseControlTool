package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.Provider;
import com.SSU.ShkodinMax.services.ProviderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.util.Scanner;

public class ProviderIOHelper {
    public static void addProvider(ProviderService providerService) {
        try {
            Provider providerToSave = new Provider();
            System.out.print("Enter Name:");
            providerToSave.setName(ConsoleInputHelper.enterString());
            System.out.print("Enter Address:");
            providerToSave.setAddress(ConsoleInputHelper.enterString());
            System.out.print("Enter Email:");
            providerToSave.setEmail(ConsoleInputHelper.enterString());
            System.out.print("Enter Phone number:");
            providerToSave.setTelephoneNumber(ConsoleInputHelper.enterString());
            providerService.addProvider(providerToSave);
            System.out.println("Success! Provider added");
        }catch (Exception e)
        {
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void deleteProvider(ProviderService providerService) {
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id:");
            int id = ConsoleInputHelper.enterPositiveIntValue();
            if(ConsoleInputHelper.getConfirmationMessageResult()){
                providerService.deleteProvider(providerService.getProviderById(id));
                System.out.println("Success! Provider deleted");
            }else{
                System.out.println("Operation canceled");
            }
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public  static void updateProvider(ProviderService providerService){
        try {
            System.out.print("Enter provider's id:");
            Provider provider = providerService.getProviderById(ConsoleInputHelper.enterPositiveIntValue());
            System.out.print("Enter Name:");
            provider.setName(ConsoleInputHelper.enterString());
            System.out.print("Enter Address:");
            provider.setAddress(ConsoleInputHelper.enterString());
            System.out.print("Enter Email:");
            provider.setEmail(ConsoleInputHelper.enterString());
            System.out.print("Enter Phone number:");
            provider.setTelephoneNumber(ConsoleInputHelper.enterString());
            if(ConsoleInputHelper.getConfirmationMessageResult()){
                providerService.updateProvider(provider);
                System.out.println("Success! Provider updated");
            }else{
                System.out.println("Operation canceled");
            }

        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void getALl(ProviderService providerService)  {
        try {
            for (Provider provider : providerService.getAll()) {
                ObjectMapper mapper = new ObjectMapper();
                mapper.enable(SerializationFeature.INDENT_OUTPUT);
                System.out.println(mapper.writeValueAsString(provider));
            }
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
}
