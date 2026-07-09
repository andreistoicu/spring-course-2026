package org.example.controller;

import jakarta.annotation.PostConstruct;
import org.example.dao.entity.Customer;
import org.example.service.CustomerService;
import org.springframework.stereotype.Controller;

@Controller
public class CustomerController {

    public final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostConstruct
    void init(){
        Customer customer = new Customer();
        Customer customer2 = new Customer();
        customer.setName("Andrei");
        customer2.setName("Gicu");

        System.out.println("saving customer : " + customer);
        System.out.println("saving customer2 : " + customer2);

        customerService.saveCustomer(customer);
        customerService.saveCustomer(customer2);

        Customer foundCustomer = customerService.findById(customer.getId());
        System.out.println("found customer : " + foundCustomer);

        customer2.setName("Andreea");
        customerService.saveCustomer(customer);

        for(Customer c : customerService.findAll()){
            System.out.println("found customer : " + c);
        }
    }
}
