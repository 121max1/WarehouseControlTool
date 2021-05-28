package com.SSU.ShkodinMax.services;

import com.SSU.ShkodinMax.model.Client;
import com.SSU.ShkodinMax.model.Product;

import java.util.List;

public interface ProductService {
    void addProduct(Product product) throws Exception;

    void updateProduct(Product product) throws Exception;

    void deleteProduct(Product product) throws Exception;

    Product getProductById(int id) throws Exception;

    List<Product> getAll();
}
