package com.room.hub.service;

import com.room.hub.bean.Salas;
import com.room.hub.dao.SalasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class SalasService {

    @Autowired
    private SalasRepository salasRepository;

    public Salas criarSala(Salas sala) throws IOException {
        // Validar campos aqui se necessário antes de salvar
        sala.setEstrela(5); // Toda sala é criada com 5 estrelas por padrão
        return salasRepository.save(sala);
    }
}


