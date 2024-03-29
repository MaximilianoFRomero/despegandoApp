package com.seminario194.Despegando.api.controllers;

import com.seminario194.Despegando.domain.entities.CustomerEntity;
import com.seminario194.Despegando.domain.entities.FlyEntity;
import com.seminario194.Despegando.domain.repositories.FlyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/fly")
public class FlyController {
    @Autowired
    private FlyRepository flyRepository;

    @GetMapping
    public List<FlyEntity> getFlies(){
        return flyRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<FlyEntity> getFlies (@PathVariable Long id){
        FlyEntity fly = flyRepository.findById(id).orElse(null);

        if(fly == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(fly);
    }
}
