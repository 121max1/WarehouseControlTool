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

    public static void addStaff(StaffService staffService) throws Exception {
        Scanner sc = new Scanner(System.in);

        Staff staffToSave = new Staff();
        System.out.print("Enter fullname: ");
        staffToSave.setFullName(sc.nextLine());
        System.out.print("Enter address: ");
        staffToSave.setAddress(sc.nextLine());
        System.out.print("Enter email: ");
        staffToSave.setEmail(sc.nextLine());
        System.out.print("Enter phone number: ");
        staffToSave.setPhoneNumber(sc.nextLine());
        System.out.print("Enter shipping date in format dd.mm.yyyy: ");
        String[] birthdayDateStr = sc.nextLine().split(" ");
        GregorianCalendar birthday = new GregorianCalendar(
                Integer.parseInt(birthdayDateStr[2]),
                Integer.parseInt(birthdayDateStr[1]),
                Integer.parseInt(birthdayDateStr[0]));
        staffToSave.setBirthday(birthday);
        System.out.print("Enter position: ");
        staffToSave.setPosition(sc.nextLine());
        staffService.addStaff(staffToSave);
    }

    public static void deleteClient(StaffService staffService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id:");
        staffService.deleteStaff(staffService.getStaffById(sc.nextInt()));
    }

    public  static void updateStaff(StaffService staffService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter staff's id:");
        Staff staffToUpdate = staffService.getStaffById(sc.nextInt());
        System.out.print("Enter fullname: ");
        staffToUpdate.setFullName(sc.nextLine());
        System.out.print("Enter address: ");
        staffToUpdate.setAddress(sc.nextLine());
        System.out.print("Enter email: ");
        staffToUpdate.setEmail(sc.nextLine());
        System.out.print("Enter phone number: ");
        staffToUpdate.setPhoneNumber(sc.nextLine());
        System.out.print("Enter shipping date in format dd.mm.yyyy: ");
        String[] birthdayDateStr = sc.nextLine().split(" ");
        GregorianCalendar birthday = new GregorianCalendar(
                Integer.parseInt(birthdayDateStr[2]),
                Integer.parseInt(birthdayDateStr[1]),
                Integer.parseInt(birthdayDateStr[0]));
        staffToUpdate.setBirthday(birthday);
        System.out.print("Enter position: ");
        staffToUpdate.setPosition(sc.nextLine());
        staffService.updateStaff(staffToUpdate);
    }
    public static void getALl(StaffService staffService) throws JsonProcessingException {
        for(Staff staff : staffService.getAll()){
            String serialized = new ObjectMapper().writeValueAsString(staff);
            System.out.println(serialized);
        }
    }
}
