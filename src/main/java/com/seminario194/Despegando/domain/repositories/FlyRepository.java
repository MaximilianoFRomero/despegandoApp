package com.seminario194.Despegando.domain.repositories;

import com.seminario194.Despegando.domain.entities.FlyEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface FlyRepository extends JpaRepository<FlyEntity, Long> {

}
