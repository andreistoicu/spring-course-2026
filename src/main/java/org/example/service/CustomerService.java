package org.example.service;

import jakarta.transaction.Transactional;
import org.example.dao.CustomerRepository;
import org.example.dto_model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository){
        this.customerRepository = customerRepository;
    }

    @Transactional
    public void saveCustomer(Customer customer){
        customerRepository.save(customer);
    }

    public Customer findById(Long id){
        return customerRepository.findById(id);
    }

    public List<Customer> findAll(){
        return customerRepository.findAll();
    }
}
