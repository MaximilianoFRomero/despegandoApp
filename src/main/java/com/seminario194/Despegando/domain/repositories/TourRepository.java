package com.seminario194.Despegando.domain.repositories;

import com.seminario194.Despegando.domain.entities.TourEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TourRepository extends JpaRepository<TourEntity, Long> {
}
