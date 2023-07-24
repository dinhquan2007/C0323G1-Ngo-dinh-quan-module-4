package com.codegym.repository;

import com.codegym.model.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<Product> getAll() {
        TypedQuery<Product> query = entityManager.createQuery("from Product", Product.class);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void save(Product product) {
       entityManager.persist(product);
    }

    @Override
    public Product findById(int id) {
        Product product = entityManager.find(Product.class, id);
        return product;
    }

    @Override
    @Transactional
    public void remove(Product product) {
        Product product1 = findById(product.getId());
        entityManager.remove(product1);
    }

    @Override
    @Transactional
    public List<Product> findByName(String name) {
        TypedQuery<Product> query = entityManager.createQuery("from Product p where p.name like :name", Product.class);
        query.setParameter("name", "%"+name+"%");
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Product product) {
        Product product1 = findById(product.getId());
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setQuantity(product.getQuantity());
        product1.setProducer(product.getProducer());
        entityManager.close();
    }
}
