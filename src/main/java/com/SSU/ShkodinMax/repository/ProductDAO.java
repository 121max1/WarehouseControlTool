package com.SSU.ShkodinMax.repository;

import com.SSU.ShkodinMax.model.Product;

import java.util.List;

public interface ProductDAO {
    Product findById(int id) throws Exception;

    void save(Product product);

    void update(Product product);

    void delete(Product product);

    List<Product> getAll();
}
