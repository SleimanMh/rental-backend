package com.carrentalsystem.services;

import com.carrentalsystem.entities.Customer;
import com.carrentalsystem.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository=customerRepository;
    }

    public Customer createClient(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer findClient(String customerName) {
        return customerRepository.findByName(customerName);
    }
}
