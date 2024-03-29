package com.seminario194.Despegando.api.controllers;

import com.seminario194.Despegando.domain.entities.CustomerEntity;
import com.seminario194.Despegando.domain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;

    @GetMapping
    public List<CustomerEntity> getCustomers(){
        return customerRepository.findAll();
    }

    @GetMapping("{dni}")
    public ResponseEntity<CustomerEntity> getCustomer (@PathVariable String dni){
        CustomerEntity customer = customerRepository.findById(dni).orElse(null);

        if(customer == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(customer);
    }
}
