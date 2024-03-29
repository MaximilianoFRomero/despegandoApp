package com.seminario194.Despegando.api.controllers;

import com.seminario194.Despegando.api.dtos.CustomerRequest;
import com.seminario194.Despegando.api.dtos.CustomersResponse;
import com.seminario194.Despegando.api.services.CustomerService;
import com.seminario194.Despegando.domain.entities.CustomerEntity;
import com.seminario194.Despegando.domain.repositories.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;


@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    @ResponseBody
    public CustomersResponse listCustomers(){
        return customerService.listCustomers();
    }

    @PostMapping("/newCustomer")
    public ResponseEntity newCustomer(@RequestBody CustomerRequest customerRequest){
        return customerService.setCustomer(customerRequest);
    }


}
