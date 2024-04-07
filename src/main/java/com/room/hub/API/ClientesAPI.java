package com.room.hub.API;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.room.hub.Class.Clientes;
import com.room.hub.Repository.ClientesRepository;

@RestController
@RequestMapping("/api")
public class ClientesAPI {

    @Autowired
    private ClientesRepository clientesRepository;

    @PostMapping("/post/")
    public ResponseEntity<Clientes> criarCliente(@RequestBody Clientes cliente) {
        Clientes novoCliente = clientesRepository.save(cliente);
        return new ResponseEntity<>(novoCliente, HttpStatus.CREATED);
    }

    @GetMapping("/get/")
    public ResponseEntity<Clientes> buscarClientePorId(@PathVariable Long id) {
        Clientes cliente = clientesRepository.findById(id)
                .orElse(null);
        if (cliente != null) {
            return ResponseEntity.ok(cliente);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/put/")
    public ResponseEntity<Clientes> atualizarCliente(@PathVariable Long id, @RequestBody Clientes novoCliente) {
        Clientes clienteExistente = clientesRepository.findById(id)
                .orElse(null);
        if (clienteExistente != null) {
            clienteExistente.setNome(novoCliente.getNome());
            Clientes clienteAtualizado = clientesRepository.save(clienteExistente);
            return ResponseEntity.ok(clienteAtualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/delete/")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        Clientes cliente = clientesRepository.findById(id)
                .orElse(null);
        if (cliente != null) {
            clientesRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
