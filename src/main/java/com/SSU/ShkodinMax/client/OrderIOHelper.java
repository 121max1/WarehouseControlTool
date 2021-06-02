package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.*;
import com.SSU.ShkodinMax.services.ClientService;
import com.SSU.ShkodinMax.services.OrderService;
import com.SSU.ShkodinMax.services.StaffService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.GregorianCalendar;

public class OrderIOHelper {
    public static void addOrder(OrderService orderService,
                                 ClientService clientService,
                                 StaffService staffService) {
        try {
            Order orderToSave = new Order();
            System.out.print("Enter Address:");
            orderToSave.setAddress(ConsoleInputHelper.enterString());
            System.out.print("Enter payment date in format dd.mm.yyyy:");
            GregorianCalendar paymentDate = ConsoleInputHelper.enterDate();
            orderToSave.setPaymentDate(paymentDate);
            System.out.print("Enter shipping date in format dd.mm.yyyy:");
            GregorianCalendar shippingDate = ConsoleInputHelper.enterDate();
            orderToSave.setShippingDate(shippingDate);
            System.out.print("Enter client's id:");
            Client client = clientService.getClientById(ConsoleInputHelper.enterPositiveIntValue());
            orderToSave.setClient(client);
            System.out.print("Enter staff's id:");
            Staff staff = staffService.getStaffById(ConsoleInputHelper.enterPositiveIntValue());
            orderToSave.setStaff(staff);
            orderService.addOrder(orderToSave);
            System.out.println("Success! Order added");
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void deleteOrder(OrderService orderService){
        try {
            System.out.print("Enter id:");
            int id = ConsoleInputHelper.enterPositiveIntValue();
            if(ConsoleInputHelper.getConfirmationMessageResult()){
                orderService.deleteOrder(orderService.getOrderById(id));
                System.out.println("Success! Order added");
            }else{
                System.out.println("Operation canceled");
            }
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void updateOrder(OrderService orderService,
                                   ClientService clientService,
                                   StaffService staffService){
        try {
            System.out.print("Enter order's id:");
            Order orderToUpdate = orderService.getOrderById(ConsoleInputHelper.enterPositiveIntValue());
            System.out.print("Enter address:");
            orderToUpdate.setAddress(ConsoleInputHelper.enterString());
            System.out.print("Enter payment date in format dd.mm.yyyy:");
            GregorianCalendar paymentDate = ConsoleInputHelper.enterDate();
            orderToUpdate.setPaymentDate(paymentDate);
            System.out.print("Enter shipping date in format dd.mm.yyyy:");
            GregorianCalendar shippingDate = ConsoleInputHelper.enterDate();
            orderToUpdate.setShippingDate(shippingDate);
            System.out.print("Enter client's id:");
            Client client = clientService.getClientById(ConsoleInputHelper.enterPositiveIntValue());
            orderToUpdate.setClient(client);
            System.out.print("Enter staff's id:");
            Staff staff = staffService.getStaffById(ConsoleInputHelper.enterPositiveIntValue());
            orderToUpdate.setStaff(staff);
            if(ConsoleInputHelper.getConfirmationMessageResult()) {
                orderService.updateOrder(orderToUpdate);
                System.out.println("Success! Order updated");
            }else{
                System.out.println("Operation canceled");
            }
        }
        catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public static void getALl(OrderService orderService) {
        try {


        for(Order order : orderService.getAll()){
            String serialized = new ObjectMapper().writeValueAsString(order);
            System.out.println(serialized);
        }}catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
}
