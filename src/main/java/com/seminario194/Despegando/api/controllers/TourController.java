package com.seminario194.Despegando.api.controllers;

import com.seminario194.Despegando.domain.entities.FlyEntity;
import com.seminario194.Despegando.domain.entities.TourEntity;
import com.seminario194.Despegando.domain.repositories.FlyRepository;
import com.seminario194.Despegando.domain.repositories.TourRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/tour")
public class TourController {
    @Autowired
    private TourRepository tourRepository;

    @GetMapping
    public List<TourEntity> getTours(){
        return tourRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<TourEntity> getTours (@PathVariable Long id){
        TourEntity tour = tourRepository.findById(id).orElse(null);

        if(tour == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(tour);
    }
}
