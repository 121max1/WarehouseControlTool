package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Product;

public interface ProductDAO {
    Product findById(int id) throws Exception;

    void save(Product product) throws Exception;

    void update(Product product) throws Exception;

    void delete(Product product) throws Exception;
}
