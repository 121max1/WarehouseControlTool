package com.SSU.ShkodinMax.client;


import com.SSU.ShkodinMax.model.Order;
import com.SSU.ShkodinMax.model.Ordered;
import com.SSU.ShkodinMax.model.Product;
import com.SSU.ShkodinMax.services.OrderService;
import com.SSU.ShkodinMax.services.OrderedService;
import com.SSU.ShkodinMax.services.ProductService;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.math.BigDecimal;

public class OrderedIOHelper {
    public static void addOrdered(OrderedService orderedService,
                           OrderService orderService,
                           ProductService productService){
        try {
            Ordered orderedToSave = new Ordered();
            System.out.print("Enter order's id:");
            Order order = orderService.getOrderById(ConsoleInputHelper.enterPositiveIntValue());
            orderedToSave.setOrder(order);
            System.out.print("Enter product's id:");
            Product product = productService.getProductById(ConsoleInputHelper.enterPositiveIntValue());
            orderedToSave.setProduct(product);
            System.out.print("Enter amount:");
            orderedToSave.setAmount(ConsoleInputHelper.enterPositiveIntValue());
            System.out.print("Enter price:");
            orderedToSave.setPrice(BigDecimal.valueOf(ConsoleInputHelper.enterPositiveIntValue()));
            orderedService.addOrdered(orderedToSave);
            System.out.println("Success! Ordered added");
        }catch (Exception e)
        {
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void deleteOrdered(OrderedService orderedService){
        try {
            System.out.print("Enter id:");
            int id = ConsoleInputHelper.enterPositiveIntValue();
            if(ConsoleInputHelper.getConfirmationMessageResult()){
                orderedService.deleteOrdered(orderedService.getOrderedById(id));
                System.out.println("Success! Ordered deleted");
            }else{
                System.out.println("Operation canceled");
            }

        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public  static void updateOrdered(OrderedService orderedService){
        try {
            Ordered ordered = orderedService.getOrderedById(ConsoleInputHelper.enterPositiveIntValue());
            System.out.print("Enter amount:");
            ordered.setAmount(ConsoleInputHelper.enterPositiveIntValue());
            System.out.print("Enter price:");
            ordered.setPrice(BigDecimal.valueOf(ConsoleInputHelper.enterPositiveIntValue()));
            if(ConsoleInputHelper.getConfirmationMessageResult()) {
                orderedService.updateOrdered(ordered);
                System.out.println("Success! Ordered updated");
            }else{
                System.out.println("Operation canceled");
            }
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public static void getALl(OrderedService orderedService){
        try {
        for(Ordered ordered : orderedService.getAll()){
            String serialized = new ObjectMapper().writeValueAsString(ordered);
            System.out.println(serialized);
        }}catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
}
