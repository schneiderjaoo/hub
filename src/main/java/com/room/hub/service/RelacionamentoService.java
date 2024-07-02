package com.room.hub.service;

import com.room.hub.bean.Clientes;
import com.room.hub.bean.Salas;
import com.room.hub.dao.ClientesRepository;
import com.room.hub.dao.SalasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RelacionamentoService {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private SalasRepository salasRepository;

    public void adicionarSalaParaCliente(Long clienteId, Long salaId) {
        Optional<Clientes> optionalCliente = clientesRepository.findById(clienteId);
        Optional<Salas> optionalSala = salasRepository.findById(salaId);

        if (optionalCliente.isPresent() && optionalSala.isPresent()) {
            Clientes cliente = optionalCliente.get();
            Salas sala = optionalSala.get();

            cliente.getSalas().add(sala);
            salasRepository.save(sala); // Salvar sala para atualizar o relacionamento no banco de dados
        } else {
            throw new IllegalArgumentException("Cliente ou sala não encontrados.");
        }
    }

    public void removerSalaDeCliente(Long clienteId, Long salaId) {
        Optional<Clientes> optionalCliente = clientesRepository.findById(clienteId);

        if (optionalCliente.isPresent()) {
            Clientes cliente = optionalCliente.get();
            cliente.getSalas().removeIf(sala -> sala.getId().equals(salaId));
            clientesRepository.save(cliente); // Salvar cliente para atualizar o relacionamento no banco de dados
        } else {
            throw new IllegalArgumentException("Cliente não encontrado.");
        }
    }
}
