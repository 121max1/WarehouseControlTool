package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.Type;
import com.SSU.ShkodinMax.services.TypeService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class TypeIOHelper {
    public static void addType(TypeService typeService) {
        try {

            Scanner sc = new Scanner(System.in);

            Type typeToSave = new Type();
            System.out.print("Enter category: ");
            typeToSave.setCategory(ConsoleInputHelper.enterString());
            System.out.print("Enter description: ");
            typeToSave.setDescription(ConsoleInputHelper.enterString());
            typeService.addType(typeToSave);
            System.out.println("Success! Type added");
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void getALl(TypeService typeService) {
        try {

            for (Type type : typeService.getAll()) {
                String serialized = new ObjectMapper().writeValueAsString(type);
                System.out.println(serialized);
            }
        }catch (Exception e) {
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void deleteType(TypeService typeService) {
        try {
            System.out.print("Enter id:");
            int id = ConsoleInputHelper.enterPositiveIntValue();
            if(ConsoleInputHelper.getConfirmationMessageResult()){
                typeService.deleteType(typeService.getTypeById(id));
                System.out.println("Success! Type deleted");
            }else{
                System.out.println("Operation canceled");
            }

        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public static void updateType(TypeService typeService){
        try {
            System.out.print("Enter type's id:");
            Type typeToSave = typeService.getTypeById(ConsoleInputHelper.enterPositiveIntValue());
            System.out.print("Enter category: ");
            typeToSave.setCategory(ConsoleInputHelper.enterString());
            System.out.print("Enter description: ");
            typeToSave.setDescription(ConsoleInputHelper.enterString());
            if(ConsoleInputHelper.getConfirmationMessageResult()){
                typeService.updateType(typeToSave);
                System.out.println("Success! Type updated");
            }else{
                System.out.println("Operation canceled");
            }
            typeService.addType(typeToSave);
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }



}
