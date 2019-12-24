package com.example.customers.controller;

import com.example.customers.model.Customers;
import com.example.customers.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    private CustomerService service;

    @GetMapping("/customers")
    public List<Customers> getAllCustomers(){
        System.out.println("hit the path");
        return service.getAll();
    }

    @GetMapping("/customers/{email}")
    public Customers getCustomerByEmail(@PathVariable String email){
        System.out.println("hit the path");
        return service.getCustomerByEmail(email);
    }

    @PostMapping("/customers/add")
    public Customers add(@Valid @ModelAttribute("customer") Customers customers, BindingResult result){
        if(result.hasErrors()){
            return null;
        }
        System.out.println("hit the path");
        System.out.println(customers.getFirstName() + "*********************************");
        return service.add(customers);
    }
}
