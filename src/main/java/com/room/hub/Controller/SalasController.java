package com.room.hub.controller;

import com.room.hub.bean.Salas;
import com.room.hub.service.SalasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/salas")
public class SalasController {

    @Autowired
    private SalasService salasService;

    @GetMapping("/criar")
    public String criarSalaForm(Model model) {
        model.addAttribute("sala", new Salas());
        return "criar_sala";
    }

    @PostMapping("/criar")
    public String criarSalaSubmit(@RequestParam String nomeSala,
                                  @RequestParam(required = false) String descricaoSala,
                                  @RequestParam double valorSala,
                                  @RequestParam int qtdeComporta,
                                  @RequestParam(required = false) String cidade,
                                  @RequestParam(required = false) String estado,
                                  @RequestParam(required = false) String endereco,
                                  Model model) {

        if (nomeSala == null || nomeSala.isEmpty()) {
            model.addAttribute("error", "O nome da sala é obrigatório.");
            return "criar_sala";
        }

        if (valorSala <= 0) {
            model.addAttribute("error", "O valor da sala deve ser maior que zero.");
            return "criar_sala";
        }

        if (qtdeComporta <= 0) {
            model.addAttribute("error", "A quantidade de comportas deve ser maior que zero.");
            return "criar_sala";
        }

        try {
            Salas novaSala = new Salas();
            novaSala.criarSalas(nomeSala, descricaoSala, valorSala, qtdeComporta, cidade, estado, endereco);
            salasService.criarSala(novaSala);
            model.addAttribute("idCriado", novaSala.getId());
            return "redirect:/salas/listar";
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao criar a sala: " + e.getMessage());
            return "criar_sala";
        }
    }

    @GetMapping("/listar")
    public String listarSalas(Model model) {
        List<Salas> salas = salasService.listarSalas();
        model.addAttribute("salas", salas);
        return "listar_salas";
    }

    @GetMapping("/editar/{id}")
    public String editarSalaForm(@PathVariable Long id, Model model) {
        Salas sala = salasService.encontrarPorId(id);
        if (sala == null) {
            return "redirect:/salas/listar";
        }
        model.addAttribute("sala", sala);
        return "editarSala";
    }

    @PostMapping("/editar/{id}")
    public String editarSalaSubmit(@PathVariable Long id, @ModelAttribute("sala") Salas salaAtualizada, Model model) {
        Salas salaExistente = salasService.encontrarPorId(id);
        if (salaExistente == null) {
            return "redirect:/salas/listar";
        }

        salaExistente.setNomeSala(salaAtualizada.getNomeSala());
        salaExistente.setDescricaoSala(salaAtualizada.getDescricaoSala());
        salaExistente.setValorSala(salaAtualizada.getValorSala());
        salaExistente.setQtdeComporta(salaAtualizada.getQtdeComporta());
        salaExistente.setCidade(salaAtualizada.getCidade());
        salaExistente.setEstado(salaAtualizada.getEstado());
        salaExistente.setEndereco(salaAtualizada.getEndereco());

        salasService.atualizarSala(salaExistente);

        return "redirect:/salas/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluirSala(@PathVariable Long id) {
        salasService.deletarSala(id);
        return "redirect:/salas/listar";
    }
}
