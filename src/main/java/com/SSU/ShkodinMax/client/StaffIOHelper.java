package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.model.Order;
import com.SSU.ShkodinMax.model.Staff;
import com.SSU.ShkodinMax.services.ClientService;
import com.SSU.ShkodinMax.services.OrderService;
import com.SSU.ShkodinMax.services.StaffService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class StaffIOHelper {

    public static void addStaff(StaffService staffService) {
        try {
            Staff staffToSave = new Staff();
            System.out.print("Enter fullname: ");
            staffToSave.setFullName(ConsoleInputHelper.enterString());
            System.out.print("Enter address: ");
            staffToSave.setAddress(ConsoleInputHelper.enterString());
            System.out.print("Enter email: ");
            staffToSave.setEmail(ConsoleInputHelper.enterString());
            System.out.print("Enter phone number: ");
            staffToSave.setPhoneNumber(ConsoleInputHelper.enterString());
            System.out.print("Enter birthday in format dd.mm.yyyy: ");
            GregorianCalendar birthday = ConsoleInputHelper.enterDate();
            staffToSave.setBirthday(birthday);
            System.out.print("Enter position: ");
            staffToSave.setPosition(ConsoleInputHelper.enterString());
            staffService.addStaff(staffToSave);
            System.out.println("Success! Staff added");
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public static void deleteStaff(StaffService staffService) {
        try {
            System.out.print("Enter id:");
            int id = ConsoleInputHelper.enterPositiveIntValue();
            if(ConsoleInputHelper.getConfirmationMessageResult()){
                staffService.deleteStaff(staffService.getStaffById(id));
                System.out.println("Success! Staff deleted");
            }else{
                System.out.println("Operation canceled");
            }

        }catch (Exception e) {
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public  static void updateStaff(StaffService staffService) {
        try {
            System.out.print("Enter staff's id:");
            Staff staffToUpdate = staffService.getStaffById(ConsoleInputHelper.enterPositiveIntValue());
            System.out.print("Enter fullname: ");
            staffToUpdate.setFullName(ConsoleInputHelper.enterString());
            System.out.print("Enter address: ");
            staffToUpdate.setAddress(ConsoleInputHelper.enterString());
            System.out.print("Enter email: ");
            staffToUpdate.setEmail(ConsoleInputHelper.enterString());
            System.out.print("Enter phone number: ");
            staffToUpdate.setPhoneNumber(ConsoleInputHelper.enterString());
            System.out.print("Enter shipping date in format dd.mm.yyyy: ");
            GregorianCalendar birthday = ConsoleInputHelper.enterDate();
            staffToUpdate.setBirthday(birthday);
            System.out.print("Enter position: ");
            staffToUpdate.setPosition(ConsoleInputHelper.enterString());
            if(ConsoleInputHelper.getConfirmationMessageResult()){
                staffService.updateStaff(staffToUpdate);
                System.out.println("Success! Staff updated");
            }else{
                System.out.println("Operation canceled");
            }
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void getALl(StaffService staffService) {
        try {
            for (Staff staff : staffService.getAll()) {
                String serialized = new ObjectMapper().writeValueAsString(staff);
                System.out.println(serialized);
            }
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
}
