package com.carrentalsystem.controllers;

import com.carrentalsystem.entities.Customer;
import com.carrentalsystem.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService){
        this.customerService=customerService;
    }

    @GetMapping("/{customerName}")
    public Customer getClient(@PathVariable String customerName){
        return customerService.findClient(customerName);
    }

    @PostMapping
    public Customer create(@RequestBody Customer customer){
        return customerService.createClient(customer);
    }

}
