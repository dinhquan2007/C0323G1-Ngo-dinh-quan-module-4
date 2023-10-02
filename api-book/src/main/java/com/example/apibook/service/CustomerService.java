package com.example.apibook.service;

import com.example.apibook.model.Customer;
import com.example.apibook.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements ICustomerService{
    @Autowired
    private ICustomerRepository customerRepository;

    @Override
    public Page<Customer> getAll(Pageable pageable, String searchName) {
        return customerRepository.findAllByNameContaining(pageable,searchName);
    }

    @Override
    public void save(Customer customer) {
      customerRepository.save(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerRepository.findById(id).orElse(null);
    }

    @Override
    public void removeCustomer(Customer customer) {
        customerRepository.delete(customer);
    }
}
