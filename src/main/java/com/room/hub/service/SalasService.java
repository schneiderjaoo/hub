package com.room.hub.service;

import com.room.hub.bean.Salas;
import com.room.hub.dao.SalasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalasService {

    @Autowired
    private SalasRepository salasRepository;

    public Salas criarSala(Salas sala) {
        Long ultimoId = salasRepository.gambi();
        sala.setId(ultimoId != null ? ultimoId + 1 : 1L);
        return salasRepository.save(sala);
    }

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
