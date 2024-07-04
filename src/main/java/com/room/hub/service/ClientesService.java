package com.room.hub.service;

import com.room.hub.bean.Clientes;
import com.room.hub.bean.Salas;
import com.room.hub.dao.ClientesRepository;
import com.room.hub.dao.SalasRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ClientesService {

    @Autowired
    private ClientesRepository repository;

    @Autowired
    private SalasRepository salasRepository;

    public Clientes findByUsuario(String usuario) {
        return repository.findByUsuario(usuario);
    }

    public Optional<Clientes> findById(Long id) {
        return repository.findById(id);
    }

    public List<Clientes> findAll() {
        return (List<Clientes>) repository.findAll();
    }

    public void save(Clientes cliente) {
        repository.save(cliente);
    }

    public void update(Clientes cliente) {
        cliente.setDataCadastro(new Date());
        repository.save(cliente);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public void relacionarClienteSala(Long clienteId, Long salaId) {
        Optional<Clientes> optionalCliente = repository.findById(clienteId);
        if (optionalCliente.isPresent()) {
            Clientes cliente = optionalCliente.get();

            Optional<Salas> optionalSala = salasRepository.findById(salaId);
            if (optionalSala.isPresent()) {
                Salas sala = optionalSala.get();

                cliente.getSalas().add(sala);
                repository.save(cliente);
                throw new IllegalArgumentException("Sala não encontrada com o ID: " + salaId);
            }
        } else {
            throw new IllegalArgumentException("Cliente não encontrado com o ID: " + clienteId);
        }
    }
}
