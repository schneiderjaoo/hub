package com.room.hub.controller;

import com.room.hub.bean.Clientes;
import com.room.hub.bean.ReservaDeSala;
import com.room.hub.bean.Salas;
import com.room.hub.service.ReservaDeSalaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservas")
public class ReservaDeSalaController {

    @Autowired
    private ReservaDeSalaService reservaDeSalaService;

    @GetMapping
    public List<ReservaDeSala> getAllReservas() {
        return reservaDeSalaService.getAllReservas();
    }

    @GetMapping("/{id}")
    public Optional<ReservaDeSala> getReservaById(@PathVariable Long id) {
        return reservaDeSalaService.getReservaById(id);
    }

    @PostMapping
    public ReservaDeSala criarReserva(@RequestParam Long clienteId, @RequestParam Long salaId, @RequestParam LocalDate dataInicio, @RequestParam LocalDate dataFim) {
        // Aqui você deve buscar as entidades Cliente e Sala pelo ID (adapte conforme necessário)
        Clientes cliente = new Clientes(); // substitua pela busca real
        Salas sala = new Salas(); // substitua pela busca real
        return reservaDeSalaService.criarReserva(cliente, sala, dataInicio, dataFim);
    }

    @PutMapping("/{id}/cancelar")
    public ReservaDeSala cancelarReserva(@PathVariable Long id, @RequestParam String motivo) {
        return reservaDeSalaService.cancelarReserva(id, motivo);
    }

    @PutMapping("/{id}/alterar")
    public ReservaDeSala alterarDataReserva(@PathVariable Long id, @RequestParam LocalDate dataInicioNova, @RequestParam LocalDate dataFimNova) {
        return reservaDeSalaService.alterarDataReserva(id, dataInicioNova, dataFimNova);
    }
}
