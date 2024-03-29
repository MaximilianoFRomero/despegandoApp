package com.seminario194.Despegando.api.controllers;

import com.seminario194.Despegando.domain.entities.FlyEntity;
import com.seminario194.Despegando.domain.entities.HotelEntity;
import com.seminario194.Despegando.domain.repositories.FlyRepository;
import com.seminario194.Despegando.domain.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
public class HotelController {
    @Autowired
    private HotelRepository hotelRepository;

    @GetMapping
    public List<HotelEntity> getHotels(){
        return hotelRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<HotelEntity> getHotels (@PathVariable Long id){
        HotelEntity hotel = hotelRepository.findById(id).orElse(null);

        if(hotel == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(hotel);
    }
}
