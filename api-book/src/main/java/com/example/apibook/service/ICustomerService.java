package com.example.apibook.service;

import com.example.apibook.model.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICustomerService {
    Page<Customer> getAll(Pageable pageable, String searchName);

    void save(Customer customer);
    Customer findById(int id);
    void removeCustomer(Customer customer);
}
