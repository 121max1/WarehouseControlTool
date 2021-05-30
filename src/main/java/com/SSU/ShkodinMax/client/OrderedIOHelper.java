package com.SSU.ShkodinMax.client;


import com.SSU.ShkodinMax.model.Order;
import com.SSU.ShkodinMax.model.Ordered;
import com.SSU.ShkodinMax.model.Product;
import com.SSU.ShkodinMax.services.OrderService;
import com.SSU.ShkodinMax.services.OrderedService;
import com.SSU.ShkodinMax.services.ProductService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class OrderedIOHelper {
    public static void addOrdered(OrderedService orderedService,
                           OrderService orderService,
                           ProductService productService){
        try {
            Scanner sc = new Scanner(System.in);
            Ordered orderedToSave = new Ordered();
            System.out.print("Enter order's id:");
            Order order = orderService.getOrderById(sc.nextInt());
            orderedToSave.setOrder(order);
            System.out.print("Enter product's id:");
            Product product = productService.getProductById(sc.nextInt());
            orderedToSave.setProduct(product);
            System.out.print("Enter amount:");
            orderedToSave.setAmount(sc.nextInt());
            System.out.print("Enter price:");
            orderedToSave.setPrice(sc.nextBigDecimal());
            orderedService.addOrdered(orderedToSave);
        }catch (Exception e)
        {
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }
    public static void deleteOrdered(OrderedService orderedService){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id:");
            orderedService.deleteOrdered(orderedService.getOrderedById(sc.nextInt()));
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public  static void updateOrdered(OrderedService orderedService){
        try {
            Scanner sc = new Scanner(System.in);
            Ordered ordered = orderedService.getOrderedById(sc.nextInt());
            System.out.print("Enter amount:");
            ordered.setAmount(sc.nextInt());
            System.out.print("Enter price:");
            ordered.setPrice(sc.nextBigDecimal());
            orderedService.updateOrdered(ordered);
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
