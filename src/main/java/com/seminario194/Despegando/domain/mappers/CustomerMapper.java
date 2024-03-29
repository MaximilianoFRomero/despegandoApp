package com.seminario194.Despegando.domain.mappers;

import com.seminario194.Despegando.api.dtos.CustomerRequest;
import com.seminario194.Despegando.api.dtos.CustomerResponse;
import com.seminario194.Despegando.api.dtos.CustomersResponse;
import com.seminario194.Despegando.domain.entities.CustomerEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerMapper {
    public static CustomerEntity customerRequestToCustomer(CustomerRequest customerRequest){

        CustomerEntity customer = new CustomerEntity();
        customer.setDni(customer.getDni());
        customer.setFullName(customerRequest.getFullName());
        customer.setCreditCard(customerRequest.getCreditCard());
        customer.setPhoneNumber(customerRequest.getPhoneNumber());
        customer.setTotalFlights(customerRequest.getTotalFlights());
        customer.setTotalLodgings(customerRequest.getTotalLodgings());
        customer.setTotalTours(customerRequest.getTotalTours());

        return customer;
    }

    public CustomersResponse customerListToResponse(List<CustomerEntity> customers){
        List<CustomersResponse> customerResponseList = new ArrayList<>();

        for(CustomerEntity customer : customers){
            CustomerRequest customerResponse = new CustomerRequest();
            customerResponse.setDni(customer.getDni());
            customerResponse.setFullName(customer.getFullName());
            customerResponse.setCreditCard(customer.getCreditCard());
            customerResponse.setPhoneNumber(customer.getPhoneNumber());
            customerResponse.setTotalFlights(customer.getTotalFlights());
            customerResponse.setTotalLodgings(customer.getTotalLodgings());
            customerResponse.setTotalTours(customer.getTotalTours());
        }
        CustomersResponse customersResponse = new CustomersResponse();
        customersResponse.setCustomers(customerResponseList);
        return customersResponse;
    }
}
