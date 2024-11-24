package com.room.hub.service;

import com.room.hub.dao.ClientesRepository;
import com.room.hub.model.Clientes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteCrudService {

    @Autowired
    private ClientesRepository clientesRepository;

    public List<Clientes> findAll() {
        return (List<Clientes>) clientesRepository.findAll(); // Agora retorna uma lista
    }

    public Optional<Clientes> findById(Long id) {
        return clientesRepository.findById(id); // Retorna um Optional
    }

    public void save(Clientes cliente) {
        clientesRepository.save(cliente); // Salva ou atualiza
    }

    public void deleteById(Long id) {
        clientesRepository.deleteById(id); // Deleta pelo ID
    }

    public Clientes findByUsuario(String usuario) {
        return clientesRepository.findByUsuario(usuario); // Busca cliente por usuário
    }
}
