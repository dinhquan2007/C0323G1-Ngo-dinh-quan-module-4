package com.codegym.service;
import com.codegym.model.Product;
import java.util.List;

public interface IProductService {
    List<Product> getAll();
    void save(Product product);
    Product findById(int id);
    void remove(Product product);
    List<Product> findByName(String name);
    void update(Product product);
}
