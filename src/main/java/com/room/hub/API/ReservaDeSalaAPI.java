package com.room.hub.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.room.hub.dao.ReservaDeSalaRepository;
import com.room.hub.bean.ReservaDeSala;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/reserva")
public class ReservaDeSalaAPI {
     
    @Autowired
    private ReservaDeSalaRepository reservaDeSalaRepository;

    @GetMapping("/{id}")//Precisa testar
    public ResponseEntity<ReservaDeSala> VerificaReservas(@PathVariable Long id) {
        Optional<ReservaDeSala> reservaOpcional = reservaDeSalaRepository.findById(id);
        return reservaOpcional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")//Precisa testar
    public ResponseEntity<List<ReservaDeSala>> verTodasAsReservas() {
        List<ReservaDeSala> reservaOpcional = (List<ReservaDeSala>) reservaDeSalaRepository.findAll();
        return ResponseEntity.ok(reservaOpcional);
    }

    @PostMapping("/")//Precisa Testar
    public ResponseEntity<ReservaDeSala> criarReserva(@Validated @RequestBody ReservaDeSala reserva) {
        ReservaDeSala novaReserva = reservaDeSalaRepository.save(reserva);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }
    
}
