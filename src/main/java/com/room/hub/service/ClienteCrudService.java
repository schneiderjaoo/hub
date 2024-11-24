package com.room.hub.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.hub.dao.ClientesRepository;
import com.room.hub.model.Clientes;

@Service
public class ClienteCrudService {

    @Autowired
    private ClientesRepository clientesRepository;

    public Clientes save(Clientes cliente) {
        return clientesRepository.save(cliente);
    }

    public Optional<Clientes> findById(Long id) {
        return clientesRepository.findById(id);
    }

    public void deleteById(Long id) {
        clientesRepository.deleteById(id);
    }

    public Iterable<Clientes> findAll() {
        return clientesRepository.findAll();
    }
}
