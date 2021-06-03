package com.SSU.ShkodinMax.client;

import com.SSU.ShkodinMax.model.*;
import com.SSU.ShkodinMax.services.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.math.BigDecimal;
import java.util.Scanner;

public class ProductIOHelper {
    public static void addProduct(ProductService productService,
                           TypeService typeService,
                           ProviderService providerService) {
        try {
            Product product = new Product();
            System.out.print("Enter product's name:");
            product.setName(ConsoleInputHelper.enterString());
            System.out.print("Enter price:");
            product.setPrice(BigDecimal.valueOf(ConsoleInputHelper.enterPositiveIntValue()));
            System.out.print("Enter unit:");
            product.setUnit(ConsoleInputHelper.enterString());
            System.out.print("Enter provider's id:");
            Provider provider = providerService.getProviderById(ConsoleInputHelper.enterPositiveIntValue());
            product.setProvider(provider);
            System.out.print("Enter type's id:");
            Type type = typeService.getTypeById(ConsoleInputHelper.enterPositiveIntValue());
            product.setType(type);
            productService.addProduct(product);
            System.out.println("Success! Product added");
        }catch (Exception e) {
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public static void deleteProduct(ProductService productService){
        try {
            System.out.print("Enter id:");
            int id = ConsoleInputHelper.enterPositiveIntValue();
            if(ConsoleInputHelper.getConfirmationMessageResult()) {
                productService.deleteProduct(productService.getProductById(id));
                System.out.println("Success! Product deleted");
            }else{
                System.out.println("Operation canceled");
            }
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public static void updateProduct(ProductService productService,
                           TypeService typeService,
                           ProviderService providerService){
        try {
            System.out.print("Enter products's id:");
            Product product = productService.getProductById(ConsoleInputHelper.enterPositiveIntValue());
            System.out.print("Enter product's name:");
            product.setName(ConsoleInputHelper.enterString());
            System.out.print("Enter price:");
            product.setPrice(BigDecimal.valueOf(ConsoleInputHelper.enterPositiveIntValue()));
            System.out.print("Enter unit:");
            product.setUnit(ConsoleInputHelper.enterString());
            System.out.print("Enter provider's id:");
            Provider provider = providerService.getProviderById(ConsoleInputHelper.enterPositiveIntValue());
            product.setProvider(provider);
            System.out.print("Enter type's id:");
            Type type = typeService.getTypeById(ConsoleInputHelper.enterPositiveIntValue());
            product.setType(type);
            if(ConsoleInputHelper.getConfirmationMessageResult()){
                productService.updateProduct(product);
                System.out.println("Success! Product updated");
            }else{
                System.out.println("Operation canceled");
            }
        }catch (Exception e){
            System.out.println("Something went wrong. Reason: " + e.getMessage());
        }
    }

    public static void getALl(ProductService productService)  {
        try{
        for(Product product : productService.getAll()){
            ObjectMapper mapper = new ObjectMapper();
            mapper.enable(SerializationFeature.INDENT_OUTPUT);
            System.out.println(mapper.writeValueAsString(product));
        }}catch(Exception e){
                System.out.println("Something went wrong. Reason: " + e.getMessage());
            }
    }

}
