package com.room.hub.api;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.room.hub.dto.SalaDTO;
import com.room.hub.model.Salas;
import com.room.hub.repository.SalasRepository;

@RestController
@RequestMapping("/api/salas")
public class SalasAPI {

    @Autowired
    private SalasRepository salasRepository;

    // POST: Criar Sala
    @PostMapping("/")
    public ResponseEntity<SalaDTO> criarSala(@Validated @RequestBody SalaDTO salaDTO) {
        Salas sala = new Salas();
        sala.setNomeSala(salaDTO.getNomeSala());
        sala.setDescricaoSala(salaDTO.getDescricaoSala());
        sala.setValorSala(salaDTO.getValorSala());
        sala.setQtdeComporta(salaDTO.getQtdeComporta());
        sala.setCidade(salaDTO.getCidade());
        sala.setEstado(salaDTO.getEstado());
        sala.setEndereco(salaDTO.getEndereco());

        Salas novaSala = salasRepository.save(sala);
        return new ResponseEntity<>(new SalaDTO(novaSala), HttpStatus.CREATED);
    }

    // GET: Buscar Sala por ID
    @GetMapping("/{id}")
    public ResponseEntity<SalaDTO> buscarSalaPorId(@PathVariable Long id) {
        Optional<Salas> salaOptional = salasRepository.findById(id);
        return salaOptional.map(sala -> ResponseEntity.ok(new SalaDTO(sala)))
                .orElse(ResponseEntity.notFound().build());
    }

    // GET: Buscar Todas as Salas
    @GetMapping("/")
    public ResponseEntity<List<SalaDTO>> buscarTodasSalas() {
        List<Salas> salas = (List<Salas>) salasRepository.findAll();
        List<SalaDTO> salasDTO = salas.stream().map(SalaDTO::new).collect(Collectors.toList());
        return ResponseEntity.ok(salasDTO);
    }

    // PUT: Atualizar Sala
    @PutMapping("/{id}")
    public ResponseEntity<SalaDTO> atualizarSala(@PathVariable Long id, @Validated @RequestBody SalaDTO salaDTO) {
        Optional<Salas> salaOptional = salasRepository.findById(id);
        if (salaOptional.isPresent()) {
            Salas salaExistente = salaOptional.get();
            salaExistente.setNomeSala(salaDTO.getNomeSala());
            salaExistente.setDescricaoSala(salaDTO.getDescricaoSala());
            salaExistente.setValorSala(salaDTO.getValorSala());
            salaExistente.setQtdeComporta(salaDTO.getQtdeComporta());
            salaExistente.setCidade(salaDTO.getCidade());
            salaExistente.setEstado(salaDTO.getEstado());
            salaExistente.setEndereco(salaDTO.getEndereco());
            Salas salaAtualizada = salasRepository.save(salaExistente);
            return ResponseEntity.ok(new SalaDTO(salaAtualizada));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // DELETE: Excluir Sala
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirSala(@PathVariable Long id) {
        if (salasRepository.existsById(id)) {
            salasRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
