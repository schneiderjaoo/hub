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
import com.room.hub.bean.Salas;

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
    
    //Precisa verificar o que vai ser mudado da reserva(Que tipo de método será)
    // @PutMapping("/{id}")
    // public ResponseEntity<ReservaDeSala> atualizarSala(@PathVariable Long id, @Validated @RequestBody ReservaDeSala novaReserva) {
    //     Optional<ReservaDeSala> reservaOpcional = reservaDeSalaRepository.findById(id);
    //     if (reservaOpcional.isPresent()) {
    //         ReservaDeSala reservaExistente = reservaOpcional.get();
    //         ReservaDeSala reservaAtualizada = reservaDeSalaRepository.save(reservaExistente);
    //         return ResponseEntity.ok(reservaAtualizada);
    //     } else {
    //         return ResponseEntity.notFound().build();
    //     }
    // }
    //Precisa verificar o que vai ser mudado da reserva

    @PostMapping("/")//Precisa Testar
    public ResponseEntity<ReservaDeSala> criarReserva(@Validated @RequestBody ReservaDeSala reserva) {
        ReservaDeSala novaReserva = reservaDeSalaRepository.save(reserva);
        return new ResponseEntity<>(novaReserva, HttpStatus.CREATED);
    }
    
}
