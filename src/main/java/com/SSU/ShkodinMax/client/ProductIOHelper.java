package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.*;
import com.SSU.ShkodinMax.services.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Scanner;

public class ProductIOHelper {
    public static void addProduct(ProductService productService,
                           TypeService typeService,
                           ProviderService providerService) throws Exception {
        try {


            Scanner sc = new Scanner(System.in);
            Product product = new Product();
            System.out.print("Enter product's name:");
            product.setName(sc.nextLine());
            System.out.print("Enter price:");
            product.setPrice(sc.nextBigDecimal());
            System.out.print("Enter unit:");
            product.setUnit(sc.nextLine());
            System.out.print("Enter provider's id:");
            Provider provider = providerService.getProviderById(sc.nextInt());
            product.setProvider(provider);
            System.out.print("Enter type's id:");
            Type type = typeService.getTypeById(sc.nextInt());
            product.setType(type);
            productService.addProduct(product);
        }catch (Exception e) {
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public static void deleteProduct(ProductService productService){
        try {


            Scanner sc = new Scanner(System.in);
            System.out.print("Enter id:");
            productService.deleteProduct(productService.getProductById(sc.nextInt()));
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public static void updateProduct(ProductService productService,
                           TypeService typeService,
                           ProviderService providerService){
        try {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter products's id:");
            Product product = productService.getProductById(sc.nextInt());
            System.out.print("Enter product's name:");
            product.setName(sc.nextLine());
            System.out.print("Enter price:");
            product.setPrice(sc.nextBigDecimal());
            System.out.print("Enter unit:");
            product.setUnit(sc.nextLine());
            System.out.print("Enter provider's id:");
            Provider provider = providerService.getProviderById(sc.nextInt());
            product.setProvider(provider);
            System.out.print("Enter type's id:");
            Type type = typeService.getTypeById(sc.nextInt());
            product.setType(type);
            productService.addProduct(product);
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public static void getALl(ProductService productService)  {
        try{
        for(Product product : productService.getAll()){
            String serialized = new ObjectMapper().writeValueAsString(product);
            System.out.println(serialized);
        }}catch(Exception e){
                System.out.println("Something went wrong. Reason: " + e.getMessage());
            }
    }

}
