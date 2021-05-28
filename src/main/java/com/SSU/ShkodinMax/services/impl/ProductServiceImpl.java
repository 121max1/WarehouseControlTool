package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.repository.ProductDAO;
import com.SSU.ShkodinMax.repository.impl.ProductDAOImpl;
import com.SSU.ShkodinMax.model.Product;
import com.SSU.ShkodinMax.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductDAO productDAO;

    public ProductServiceImpl(){
        productDAO = new ProductDAOImpl();
    }

    @Override
    public void addProduct(Product product) throws Exception {
        productDAO.save(product);
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        productDAO.update(product);
    }

    @Override
    public void deleteProduct(Product product) throws Exception {
        productDAO.delete(product);
    }

    @Override
    public Product getProductById(int id) throws Exception {
        return productDAO.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
