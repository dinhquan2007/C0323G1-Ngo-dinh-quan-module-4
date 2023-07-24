package com.codegym.service;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    private IProductRepository productRepository;
    @Override
    public List<Product> getAll() {
        return productRepository.getAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void remove(Product product) {
      productRepository.remove(product);
    }

    @Override
    public List<Product> findByName(String name) {
        if (name!=null){
            return productRepository.findByName(name);
        }
        else {
            return getAll();
        }
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }
}
