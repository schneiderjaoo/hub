package com.room.hub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.room.hub.bean.ReservaDeSala;
import com.room.hub.dao.ReservaDeSalaRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaDeSalaService {

    @Autowired
    private ReservaDeSalaRepository repository;

    public List<ReservaDeSala> findAll() {
        return (List<ReservaDeSala>) repository.findAll();
    }

    public Optional<ReservaDeSala> findById(Long id) {
        return repository.findById(id);
    }

    public void save(ReservaDeSala reserva) {
        repository.save(reserva);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
