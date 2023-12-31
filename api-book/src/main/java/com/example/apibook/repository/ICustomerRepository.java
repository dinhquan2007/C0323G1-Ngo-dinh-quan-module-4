package com.example.apibook.repository;

import com.example.apibook.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICustomerRepository extends JpaRepository<Customer,Integer> {
    Page<Customer> findAllByNameContaining(Pageable pageable,String name);
}
