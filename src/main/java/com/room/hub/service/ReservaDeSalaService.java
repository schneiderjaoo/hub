package com.room.hub.service;

import com.room.hub.bean.Clientes;
import com.room.hub.bean.ReservaDeSala;
import com.room.hub.bean.Salas;
import com.room.hub.dao.ReservaDeSalaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservaDeSalaService {

    @Autowired
    private ReservaDeSalaRepository reservaDeSalaRepository;

    public List<ReservaDeSala> getAllReservas() {
        return (List<ReservaDeSala>) reservaDeSalaRepository.findAll();
    }

    public Optional<ReservaDeSala> getReservaById(Long id) {
        return reservaDeSalaRepository.findById(id);
    }

    public ReservaDeSala criarReserva(Clientes cliente, Salas sala, LocalDate dataInicio, LocalDate dataFim) {
        ReservaDeSala reserva = new ReservaDeSala();
        reserva.criarReserva(cliente, sala, dataInicio, dataFim);
        return reservaDeSalaRepository.save(reserva);
    }

    public ReservaDeSala cancelarReserva(Long id, String motivo) {
        Optional<ReservaDeSala> reservaOptional = reservaDeSalaRepository.findById(id);
        if (reservaOptional.isPresent()) {
            ReservaDeSala reserva = reservaOptional.get();
            reserva.cancelarReserva(motivo, LocalDate.now());
            return reservaDeSalaRepository.save(reserva);
        }
        return null;
    }

    public ReservaDeSala alterarDataReserva(Long id, LocalDate dataInicioNova, LocalDate dataFimNova) {
        Optional<ReservaDeSala> reservaOptional = reservaDeSalaRepository.findById(id);
        if (reservaOptional.isPresent()) {
            ReservaDeSala reserva = reservaOptional.get();
            reserva.alterarDataReserva(dataInicioNova, dataFimNova);
            return reservaDeSalaRepository.save(reserva);
        }
        return null;
    }
}
