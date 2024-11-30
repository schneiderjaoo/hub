package com.room.hub.api;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.room.hub.model.ReservaDeSala;
import com.room.hub.repository.ReservaDeSalaRepository;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/reservas")
public class ReservaDeSalaAPI {

    @Autowired
    private ReservaDeSalaRepository reservaDeSalaRepository;

    // Buscar uma reserva por ID
    @GetMapping("/{id}")
    public ResponseEntity<ReservaDeSala> getReservaById(@PathVariable Long id) {
        Optional<ReservaDeSala> reserva = reservaDeSalaRepository.findById(id);
        return reserva.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    // Buscar todas as reservas
    @GetMapping("/")
    public ResponseEntity<List<ReservaDeSala>> getAllReservas() {
        List<ReservaDeSala> reservas = (List<ReservaDeSala>) reservaDeSalaRepository.findAll();
        return reservas.isEmpty() 
                ? ResponseEntity.noContent().build() 
                : ResponseEntity.ok(reservas);
    }

    // Criar uma nova reserva
    @PostMapping("/")
    public ResponseEntity<ReservaDeSala> criarReserva(@Validated @RequestBody ReservaDeSala reserva) {
        if (reserva.getSala() == null || reserva.getCliente() == null) {
            return ResponseEntity.badRequest().build(); // Verificar se há sala e cliente antes de salvar
        }
        ReservaDeSala novaReserva = reservaDeSalaRepository.save(reserva);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }
}
