package com.seminario194.Despegando.domain.repositories;

import com.seminario194.Despegando.domain.entities.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<HotelEntity, Long> {
}
