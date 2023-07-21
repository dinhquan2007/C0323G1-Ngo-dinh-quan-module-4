package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository{
    private static final List<Product> productList=new ArrayList<>();
    static {
        productList.add(new Product(1,"Chocolate",20,20000,"Orion"));
        productList.add(new Product(2,"egg",200,2000,"Orion"));
        productList.add(new Product(3,"Banh trung",20,30000,"Orion"));
        productList.add(new Product(4,"banh gao",20,20000,"Orion"));
        productList.add(new Product(5,"nice",20,20000,"Orion"));
    }
    @Override
    public List<Product> getAll() {

        return productList;
    }

    @Override
    public void save(Product product) {
    productList.add(product);
    }

    @Override
    public Product findById(int id) {
        for (Product p:productList) {
            if (p.getId()==id){
                return p;
            }
        }
        return null;
    }

    @Override
    public void remove(Product product) {
    productList.remove(product);
    }

    @Override
    public List<Product> findByName(String name) {
        return null;
    }

    @Override
    public void update(Product product) {
        for (int i = 0; i < productList.size(); i++) {
            if(product.getId()==productList.get(i).getId()){
                productList.set(i, product);
                return;
            }
        }
    }
}
