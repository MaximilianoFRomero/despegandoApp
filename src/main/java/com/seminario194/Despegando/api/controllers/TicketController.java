package com.seminario194.Despegando.api.controllers;

import com.seminario194.Despegando.domain.entities.FlyEntity;
import com.seminario194.Despegando.domain.entities.TicketEntity;
import com.seminario194.Despegando.domain.repositories.FlyRepository;
import com.seminario194.Despegando.domain.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/ticket")
public class TicketController {
    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping
    public List<TicketEntity> getTickets(){
        return ticketRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<TicketEntity> getTickets (@PathVariable UUID id){
        TicketEntity ticket = ticketRepository.findById(id).orElse(null);

        if(ticket == null){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(ticket);
    }
}
