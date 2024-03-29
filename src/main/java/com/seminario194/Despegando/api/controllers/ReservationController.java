package com.seminario194.Despegando.api.controllers;

import com.seminario194.Despegando.domain.entities.FlyEntity;
import com.seminario194.Despegando.domain.entities.ReservationEntity;
import com.seminario194.Despegando.domain.repositories.FlyRepository;
import com.seminario194.Despegando.domain.repositories.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private ReservationRepository reservationRepository;

    @GetMapping
    public List<ReservationEntity> getReserves(){
        return reservationRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<ReservationEntity> getReserves (@PathVariable UUID id){
        ReservationEntity reservation = reservationRepository.findById(id).orElse(null);

        if(reservation == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(reservation);
    }
}
