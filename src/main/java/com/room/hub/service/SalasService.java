package com.room.hub.service;

import com.room.hub.model.Salas;
import com.room.hub.repository.SalasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalasService {

    @Autowired
    private SalasRepository salasRepository;

    public List<Salas> listarSalas() {
        return (List<Salas>) salasRepository.findAll();
    }

    public Salas encontrarPorId(Long id) {
        return salasRepository.findById(id).orElse(null);
    }

    public void deletarSala(Long id) {
        salasRepository.deleteById(id);
    }

    public Salas atualizarSala(Salas sala) {
        return salasRepository.save(sala);
    }
}
