package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.Provider;
import com.SSU.ShkodinMax.services.ProviderService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class ProviderIOHelper {
    public static void addProvider(ProviderService providerService) throws Exception {
        Scanner sc = new Scanner(System.in);

        Provider providerToSave = new Provider();
        System.out.print("Enter Name:");
        providerToSave.setName(sc.nextLine());
        System.out.print("Enter Address:");
        providerToSave.setAddress(sc.nextLine());
        System.out.print("Enter Email:");
        providerToSave.setEmail(sc.nextLine());
        System.out.print("Enter Phone number:");
        providerToSave.setTelephoneNumber(sc.nextLine());
        providerService.addProvider(providerToSave);
    }
    public static void deleteProvider(ProviderService providerService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id:");
        providerService.deleteProvider(providerService.getProviderById(sc.nextInt()));
    }
    public  static void updateClient(ProviderService providerService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter provider's id:");
        Provider provider = providerService.getProviderById(sc.nextInt());
        System.out.print("Enter Name:");
        provider.setName(sc.nextLine());
        System.out.print("Enter Address:");
        provider.setAddress(sc.nextLine());
        System.out.print("Enter Email:");
        provider.setEmail(sc.nextLine());
        System.out.print("Enter Phone number:");
        provider.setTelephoneNumber(sc.nextLine());
        providerService.updateProvider(provider);
    }
    public static void getALl(ProviderService providerService) throws JsonProcessingException {
        for(Provider provider : providerService.getAll()){
            String serialized = new ObjectMapper().writeValueAsString(provider);
            System.out.println(serialized);
        }
    }
}
