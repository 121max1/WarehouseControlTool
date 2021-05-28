package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.model.Staff;
import com.SSU.ShkodinMax.model.Type;
import com.SSU.ShkodinMax.services.ClientService;
import com.SSU.ShkodinMax.services.StaffService;
import com.SSU.ShkodinMax.services.TypeService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class TypeIOHelper {
    public static void addType(TypeService typeService) throws Exception {
        Scanner sc = new Scanner(System.in);

        Type typeToSave = new Type();
        System.out.print("Enter category: ");
        typeToSave.setCategory(sc.nextLine());
        System.out.print("Enter description: ");
        typeToSave.setDescription(sc.nextLine());
        typeService.addType(typeToSave);
    }
    public static void getALl(TypeService typeService) throws JsonProcessingException {
        for(Type type : typeService.getAll()){
            String serialized = new ObjectMapper().writeValueAsString(type);
            System.out.println(serialized);
        }
    }
    public static void deleteType(TypeService typeService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id:");
        typeService.deleteType(typeService.getTypeById(sc.nextInt()));
    }

    public static void updateType(TypeService typeService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter type's id:");
        Type typeToSave = typeService.getTypeById(sc.nextInt());
        System.out.print("Enter category: ");
        typeToSave.setCategory(sc.nextLine());
        System.out.print("Enter description: ");
        typeToSave.setDescription(sc.nextLine());
        typeService.addType(typeToSave);
    }



}
