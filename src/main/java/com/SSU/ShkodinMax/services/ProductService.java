package com.SSU.ShkodinMax.services;

import com.SSU.ShkodinMax.model.Product;

public interface ProductService {
    void addProduct(Product product) throws Exception;

    void updateProduct(Product product) throws Exception;

    void deleteProduct(Product product) throws Exception;

    Product getProductById(int id) throws Exception;

}
