package com.example.apibook.controller;

import com.example.apibook.model.Customer;
import com.example.apibook.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/customer")
@CrossOrigin("*")
public class CustomerController {
    @Autowired
    private ICustomerService customerService;

    @GetMapping("")
    public ResponseEntity<Page<Customer>> getAll(@RequestParam("searchName") String searchName,
                                                 @RequestParam("page") int page,
                                                 @RequestParam("limit") int limit
                                                 ) {
        Pageable pageable = PageRequest.of(page, limit);
        Page<Customer> customerPage = customerService.getAll(pageable, searchName);
        return new ResponseEntity<>(customerPage, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> addCustomer(@RequestBody Customer customer) {
        customerService.save(customer);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> editCustomer(@PathVariable int id, @RequestBody Customer customer) {
        Customer customer1 = customerService.findById(id);
        BeanUtils.copyProperties(customer, customer1);
        customerService.save(customer1);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeCustomer(@PathVariable int id) {
        Customer customer = customerService.findById(id);
        customerService.removeCustomer(customer);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
