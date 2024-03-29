package com.seminario194.Despegando.domain.repositories;

import com.seminario194.Despegando.domain.entities.CustomerEntity;
import com.seminario194.Despegando.domain.entities.FlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends JpaRepository<CustomerEntity, String> {
}
