package com.SSU.ShkodinMax.services.impl;

import com.SSU.ShkodinMax.dao.ProductRepository;
import com.SSU.ShkodinMax.dao.impl.ProductRepositoryImpl;
import com.SSU.ShkodinMax.model.Product;
import com.SSU.ShkodinMax.services.ProductService;

import java.util.List;

public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    public ProductServiceImpl(){
        productRepository = new ProductRepositoryImpl();
    }

    @Override
    public void addProduct(Product product) throws Exception {
        productRepository.save(product);
    }

    @Override
    public void updateProduct(Product product) throws Exception {
        productRepository.update(product);
    }

    @Override
    public void deleteProduct(Product product) throws Exception {
        productRepository.delete(product);
    }

    @Override
    public Product getProductById(int id) throws Exception {
        return productRepository.findById(id);
    }

    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }
}
