package com.room.hub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.room.hub.bean.Clientes;
import com.room.hub.dao.ClientesRepository;
import java.util.Random;
import java.util.stream.StreamSupport;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository repository;

    public Clientes findByUsuario(String usuario) {
        return repository.findByUsuario(usuario);
    }

    public void save(Clientes cliente) {
        repository.save(cliente);
    }
}
