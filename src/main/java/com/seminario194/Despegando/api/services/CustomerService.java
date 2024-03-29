package com.seminario194.Despegando.api.services;

import com.seminario194.Despegando.api.dtos.CustomerRequest;
import com.seminario194.Despegando.api.dtos.CustomersResponse;
import com.seminario194.Despegando.domain.entities.CustomerEntity;
import com.seminario194.Despegando.domain.mappers.CustomerMapper;
import com.seminario194.Despegando.domain.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerMapper customerMapper;

    public ResponseEntity setCustomer(CustomerRequest customerRequest) {

        CustomerEntity customer = CustomerMapper.customerRequestToCustomer(customerRequest);
        customerRepository.save(customer);
        return ResponseEntity.ok("Customer saved: " + customer.getFullName() + " ");
    }

    public CustomersResponse listCustomers() {
        List<CustomerEntity> listCustomer = customerRepository.findAll();
        return customerMapper.customerListToResponse(listCustomer);
    }

    public Optional<CustomerEntity> getByDni(String dni) {
        return customerRepository.findById(dni);
    }

    public CustomerEntity save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }
}
