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
    public void addOrdered(OrderedService orderedService,
                           OrderService orderService,
                           ProductService productService) throws Exception {
        Scanner sc = new Scanner(System.in);

        Ordered orderedToSave = new Ordered();
        System.out.print("Enter order's id:");
        Order order =  orderService.getOrderById(sc.nextInt());
        orderedToSave.setOrder(order);
        System.out.print("Enter product's id:");
        Product product = productService.getProductById(sc.nextInt());
        orderedToSave.setProduct(product);
        System.out.print("Enter amount:");
        orderedToSave.setAmount(sc.nextInt());
        System.out.print("Enter price:");
        orderedToSave.setPrice(sc.nextBigDecimal());
        orderedService.addOrdered(orderedToSave);
    }
    public static void deleteOrdered(OrderedService orderedService) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter id:");
        orderedService.deleteOrdered(orderedService.getOrderedById(sc.nextInt()));
    }

    public  static void updateOrdered(OrderedService orderedService) throws Exception {
        Scanner sc = new Scanner(System.in);
        Ordered ordered = orderedService.getOrderedById(sc.nextInt());
        System.out.print("Enter amount:");
        ordered.setAmount(sc.nextInt());
        System.out.print("Enter price:");
        ordered.setPrice(sc.nextBigDecimal());
        orderedService.updateOrdered(ordered);
    }

    public static void getALl(OrderedService orderedService) throws JsonProcessingException {
        for(Ordered ordered : orderedService.getAll()){
            String serialized = new ObjectMapper().writeValueAsString(ordered);
            System.out.println(serialized);
        }
    }
}
