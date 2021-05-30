package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.*;
import com.SSU.ShkodinMax.services.ClientService;
import com.SSU.ShkodinMax.services.OrderService;
import com.SSU.ShkodinMax.services.StaffService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.GregorianCalendar;
import java.util.Scanner;

public class OrderIOHelper {
    public static void addOrder(OrderService orderService,
                                 ClientService clientService,
                                 StaffService staffService) {
        try {
            Scanner sc = new Scanner(System.in);

            Order orderToSave = new Order();
            System.out.print("Enter Address:");
            orderToSave.setAddress(sc.nextLine());
            System.out.print("Enter payment date in format dd.mm.yyyy:");
            String[] paymentDateStr = sc.nextLine().split(" ");
            GregorianCalendar paymentDate = new GregorianCalendar(
                    Integer.parseInt(paymentDateStr[2]),
                    Integer.parseInt(paymentDateStr[1]),
                    Integer.parseInt(paymentDateStr[0]));
            orderToSave.setPaymentDate(paymentDate);
            System.out.print("Enter shipping date in format dd.mm.yyyy:");
            String[] shippingDateStr = sc.nextLine().split(" ");
            GregorianCalendar shippingDate = new GregorianCalendar(
                    Integer.parseInt(shippingDateStr[2]),
                    Integer.parseInt(shippingDateStr[1]),
                    Integer.parseInt(shippingDateStr[0]));
            orderToSave.setShippingDate(shippingDate);
            System.out.print("Enter client's id:");
            Client client = clientService.getClientById(sc.nextInt());
            orderToSave.setClient(client);
            System.out.print("Enter staff's id:");
            Staff staff = staffService.getStaffById(sc.nextInt());
            orderToSave.setStaff(staff);
            orderService.addOrder(orderToSave);
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void deleteOrder(OrderService orderService){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id:");
            orderService.deleteOrder(orderService.getOrderById(sc.nextInt()));
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void updateOrder(OrderService orderService,
                                   ClientService clientService,
                                   StaffService staffService){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter order's id:");
            Order orderToUpdate = orderService.getOrderById(sc.nextInt());
            System.out.print("Enter address:");
            orderToUpdate.setAddress(sc.nextLine());
            System.out.print("Enter payment date in format dd.mm.yyyy:");
            String[] paymentDateStr = sc.nextLine().split(" ");
            GregorianCalendar paymentDate = new GregorianCalendar(
                    Integer.parseInt(paymentDateStr[2]),
                    Integer.parseInt(paymentDateStr[1]),
                    Integer.parseInt(paymentDateStr[0]));
            orderToUpdate.setPaymentDate(paymentDate);
            System.out.print("Enter shipping date in format dd.mm.yyyy:");
            String[] shippingDateStr = sc.nextLine().split(" ");
            GregorianCalendar shippingDate = new GregorianCalendar(
                    Integer.parseInt(shippingDateStr[2]),
                    Integer.parseInt(shippingDateStr[1]),
                    Integer.parseInt(shippingDateStr[0]));
            orderToUpdate.setShippingDate(shippingDate);
            System.out.print("Enter client's id:");
            Client client = clientService.getClientById(sc.nextInt());
            orderToUpdate.setClient(client);
            System.out.print("Enter staff's id:");
            Staff staff = staffService.getStaffById(sc.nextInt());
            orderToUpdate.setStaff(staff);
            orderService.updateOrder(orderToUpdate);
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
