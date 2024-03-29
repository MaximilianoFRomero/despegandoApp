package com.seminario194.Despegando.api.dtos;

import jakarta.persistence.Column;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class CustomerRequest {
    @NotEmpty
    private String dni;
    private String fullName;
    private String creditCard;
    private String phoneNumber;
    private Integer totalFlights;
    private Integer totalLodgings;
    private Integer totalTours;
}
