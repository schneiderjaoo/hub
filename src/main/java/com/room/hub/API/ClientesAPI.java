package com.room.hub.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.room.hub.bean.Clientes;
import com.room.hub.bean.Salas;
import com.room.hub.dao.ClientesRepository;
import com.room.hub.dao.SalasRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClientesAPI {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private SalasRepository salasRepository;

    @PostMapping("/")
    public ResponseEntity<Clientes> criarCliente(@Validated @RequestBody Clientes cliente) {
        Clientes novoCliente = clientesRepository.save(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Clientes> buscarClientePorId(@PathVariable Long id) {
        Clientes cliente = clientesRepository.findById(id).orElse(null);
        return cliente != null ? ResponseEntity.ok(cliente) : ResponseEntity.notFound().build();
    }

    @GetMapping("/")
    public ResponseEntity<List<Clientes>> buscarTodosClientes() {
        List<Clientes> clientes = (List<Clientes>) clientesRepository.findAll();
        return ResponseEntity.ok(clientes);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Clientes> atualizarCliente(@PathVariable Long id, @Validated @RequestBody Clientes novoCliente) {
        Clientes clienteExistente = clientesRepository.findById(id).orElse(null);
        if (clienteExistente == null) {
            return ResponseEntity.notFound().build();
        }
        clienteExistente.alteraSenha(novoCliente.getSenha());
        clienteExistente.alteraNomeCliente(novoCliente.getNome());

        clientesRepository.save(clienteExistente);
        return ResponseEntity.ok(clienteExistente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        Clientes cliente = clientesRepository.findById(id).orElse(null);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }

        clientesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{clienteId}/salas/{salaId}")
    public ResponseEntity<Clientes> vincularSala(@PathVariable Long clienteId, @PathVariable Long salaId) {
        Clientes cliente = clientesRepository.findById(clienteId).orElse(null);
        Salas sala = salasRepository.findById(salaId).orElse(null);
        if (cliente == null || sala == null) {
            return ResponseEntity.notFound().build();
        }

        cliente.getSalas().add(sala);
        sala.getClientes().add(cliente);
        clientesRepository.save(cliente);
        salasRepository.save(sala);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{clienteId}/salas/{salaId}")
    public ResponseEntity<Clientes> desvincularSala(@PathVariable Long clienteId, @PathVariable Long salaId) {
        Clientes cliente = clientesRepository.findById(clienteId).orElse(null);
        Salas sala = salasRepository.findById(salaId).orElse(null);
        if (cliente == null || sala == null) {
            return ResponseEntity.notFound().build();
        }

        cliente.getSalas().remove(sala);
        sala.getClientes().remove(cliente);
        clientesRepository.save(cliente);
        salasRepository.save(sala);

        return ResponseEntity.ok(cliente);
    }
}


