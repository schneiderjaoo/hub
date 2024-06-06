package com.room.hub.API;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import com.room.hub.Class.Salas;
import com.room.hub.Repository.SalasRepository;

// @RestController
// @RequestMapping("/api/salas")
// public class SalasAPI {

//     @Autowired
//     private SalasRepository salasRepository;

//     @PostMapping("/")
//     public ResponseEntity<Salas> criarSala(@Validated @RequestBody Salas sala) {
//         sala.criarSalas(sala.getNomeSala(),sala.getDescricaoSala(),sala.getSituacaoSala() ,sala.getValorSala());
//         System.out.println(sala.getNomeSala());
//         System.out.println(sala.getDescricaoSala());
//         System.out.println(sala.getSituacaoSala());
//         System.out.println(sala.getValorSala());
//         System.out.println(sala.getDescricaoSit());
//         Salas novaSala = salasRepository.save(sala);
//         return new ResponseEntity<>(novaSala, HttpStatus.CREATED);
//     }

//     @GetMapping("/{id}")
//     public ResponseEntity<Salas> buscarSalaPorId(@PathVariable Long id) {
//         Optional<Salas> salaOptional = salasRepository.findById(id);
//         return salaOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
//     }

//     @GetMapping("/")
//     public ResponseEntity<List<Salas>> buscarTodasSalas() {
//         List<Salas> salas = (List<Salas>) salasRepository.findAll();
//         return ResponseEntity.ok(salas);
//     }

//     @PutMapping("/{id}")
//     public ResponseEntity<Salas> atualizarSala(@PathVariable Long id, @Validated @RequestBody Salas novaSala) {
//         Optional<Salas> salaOptional = salasRepository.findById(id);
//         if (salaOptional.isPresent()) {
//             Salas salaExistente = salaOptional.get(); 
//             salaExistente.alteraNomeSala(novaSala.getNomeSala());
//             salaExistente.alteraDescricaoSala(novaSala.getDescricaoSala());
//             salaExistente.alteraSituacaoSala(novaSala.getSituacaoSala());
//             salaExistente.alteraDescricaoSituacaoSala(novaSala.defineSituacao(novaSala.getSituacaoSala()));
//             salaExistente.alteraValorSala(novaSala.getValorSala());
//             salaExistente.estrela(novaSala.getEstrela());
//             Salas salaAtualizada = salasRepository.save(salaExistente);
//             return ResponseEntity.ok(salaAtualizada);
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }

//     @DeleteMapping("/{id}")
//     public ResponseEntity<Void> excluirSala(@PathVariable Long id) {
//         if (salasRepository.existsById(id)) {
//             salasRepository.deleteById(id);
//             return ResponseEntity.noContent().build();
//         } else {
//             return ResponseEntity.notFound().build();
//         }
//     }
// }

@RestController
@RequestMapping("/api/salas")
public class SalasAPI {

    @Autowired
    private SalasRepository salasRepository;

    @PostMapping("/")
    public ResponseEntity<Salas> criarSala(@Validated @RequestBody Salas sala) {
        Salas novaSala = salasRepository.save(sala);
        return new ResponseEntity<>(novaSala, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Salas> buscarSalaPorId(@PathVariable Long id) {
        Optional<Salas> salaOptional = salasRepository.findById(id);
        return salaOptional.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/")
    public ResponseEntity<List<Salas>> buscarTodasSalas() {
        List<Salas> salas = (List<Salas>) salasRepository.findAll();
        return ResponseEntity.ok(salas);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Salas> atualizarSala(@PathVariable Long id, @Validated @RequestBody Salas novaSala) {
        Optional<Salas> salaOptional = salasRepository.findById(id);
        if (salaOptional.isPresent()) {
            Salas salaExistente = salaOptional.get();
            salaExistente.alteraNomeSala(novaSala.getNomeSala());
            salaExistente.alteraDescricaoSala(novaSala.getDescricaoSala());
            salaExistente.alteraSituacaoSala(novaSala.getSituacaoSala());
            salaExistente.alteraDescricaoSituacaoSala(novaSala.defineSituacao(novaSala.getSituacaoSala()));
            salaExistente.alteraValorSala(novaSala.getValorSala());
            salaExistente.estrela(novaSala.getEstrela());
            Salas salaAtualizada = salasRepository.save(salaExistente);
            return ResponseEntity.ok(salaAtualizada);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

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
