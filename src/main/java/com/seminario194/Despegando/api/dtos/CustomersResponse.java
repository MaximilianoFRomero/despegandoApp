package com.seminario194.Despegando.api.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.util.List;

@Data
public class CustomersResponse {
    private List<CustomersResponse> customers;
}
