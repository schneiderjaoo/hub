package com.room.hub.api;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.room.hub.dto.ClienteDTO;
import com.room.hub.model.Clientes;
import com.room.hub.model.Salas;
import com.room.hub.repository.ClientesRepository;
import com.room.hub.repository.SalasRepository;

@RestController
@RequestMapping("/api/clientes")
public class ClientesAPI {

    @Autowired
    private ClientesRepository clientesRepository;

    @Autowired
    private SalasRepository salasRepository;

    // POST: Criar Cliente
    @PostMapping("/")
    public ResponseEntity<ClienteDTO> criarCliente(@Validated @RequestBody ClienteDTO clienteDTO) {
        Clientes cliente = new Clientes();
        cliente.setNome(clienteDTO.getNome());
        cliente.setUsuario(clienteDTO.getUsuario());
        cliente.setEmailUsuario(clienteDTO.getEmailUsuario());
        cliente.setSenha(clienteDTO.getSenha());
        cliente.setCpf(clienteDTO.getCpf());

        Clientes novoCliente = clientesRepository.save(cliente);
        return new ResponseEntity<>(new ClienteDTO(novoCliente), HttpStatus.CREATED);
    }

    // GET: Buscar Cliente por ID
    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long id) {
        Clientes cliente = clientesRepository.findById(id).orElse(null);
        if (cliente == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(new ClienteDTO(cliente));
    }

    // GET: Buscar Todos os Clientes
    @GetMapping("/")
    public ResponseEntity<List<ClienteDTO>> buscarTodosClientes() {
        List<Clientes> clientes = (List<Clientes>) clientesRepository.findAll();
        List<ClienteDTO> clientesDTO = clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(clientesDTO);
    }

    // PUT: Atualizar Cliente
    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> atualizarCliente(@PathVariable Long id, @Validated @RequestBody ClienteDTO clienteDTO) {
        Clientes clienteExistente = clientesRepository.findById(id).orElse(null);
        if (clienteExistente == null) {
            return ResponseEntity.notFound().build();
        }

        clienteExistente.setNome(clienteDTO.getNome());
        clienteExistente.setSenha(clienteDTO.getSenha());
        clienteExistente.setUsuario(clienteDTO.getUsuario());
        clienteExistente.setEmailUsuario(clienteDTO.getEmailUsuario());

        Clientes clienteAtualizado = clientesRepository.save(clienteExistente);
        return ResponseEntity.ok(new ClienteDTO(clienteAtualizado));
    }

    // DELETE: Excluir Cliente
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirCliente(@PathVariable Long id) {
        if (!clientesRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        clientesRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    // POST: Vincular Sala ao Cliente
    @PostMapping("/{clienteId}/salas/{salaId}")
    public ResponseEntity<ClienteDTO> vincularSala(@PathVariable Long clienteId, @PathVariable Long salaId) {
        Clientes cliente = clientesRepository.findById(clienteId).orElse(null);
        Salas sala = salasRepository.findById(salaId).orElse(null);
        if (cliente == null || sala == null) {
            return ResponseEntity.notFound().build();
        }

        cliente.adicionarSala(sala);
        clientesRepository.save(cliente);

        return ResponseEntity.ok(new ClienteDTO(cliente));
    }

    // DELETE: Desvincular Sala do Cliente
    @DeleteMapping("/{clienteId}/salas/{salaId}")
    public ResponseEntity<ClienteDTO> desvincularSala(@PathVariable Long clienteId, @PathVariable Long salaId) {
        Clientes cliente = clientesRepository.findById(clienteId).orElse(null);
        Salas sala = salasRepository.findById(salaId).orElse(null);
        if (cliente == null || sala == null) {
            return ResponseEntity.notFound().build();
        }

        cliente.removerSala(sala);
        clientesRepository.save(cliente);

        return ResponseEntity.ok(new ClienteDTO(cliente));
    }
}
