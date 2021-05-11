package com.SSU.ShkodinMax.dao;

import com.SSU.ShkodinMax.model.Product;

public interface ProductDAO {
    Product findById(int id);

    void save(Product product);

    void update(Product product);

    void delete(Product product);
}
