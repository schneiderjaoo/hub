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
    public String criarSalaSubmit(@ModelAttribute("sala") Salas sala, Model model) {
        // Validação manual dos campos
        if (sala.getNomeSala() == null || sala.getNomeSala().isEmpty()) {
            model.addAttribute("error", "O nome da sala é obrigatório.");
            return "criar_sala";
        }

        if (sala.getValorSala() <= 0) {
            model.addAttribute("error", "O valor da sala deve ser maior que zero.");
            return "criar_sala";
        }

        if (sala.getQtdeComporta() == null || sala.getQtdeComporta() <= 0) {
            model.addAttribute("error", "A quantidade de comportas deve ser maior que zero.");
            return "criar_sala";
        }

        // Continuar com o processamento se não houver erros
        try {
            Salas novaSala = salasService.criarSala(sala);

            model.addAttribute("idCriado", novaSala.getId()); // Passa o ID criado para o modelo

            // Redireciona para a página de listagem após a criação da sala
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
            // Implementar tratamento para sala não encontrada, se necessário
            return "redirect:/salas/listar";
        }
        model.addAttribute("sala", sala);
        return "editar_sala";
    }

    @PostMapping("/editar/{id}")
    public String editarSalaSubmit(@PathVariable Long id, @ModelAttribute("sala") Salas salaAtualizada, Model model) {
        Salas salaExistente = salasService.encontrarPorId(id);
        if (salaExistente == null) {
            // Implementar tratamento para sala não encontrada, se necessário
            return "redirect:/salas/listar";
        }

        // Atualizar os campos da sala existente com os novos valores
        salaExistente.setNomeSala(salaAtualizada.getNomeSala());
        salaExistente.setDescricaoSala(salaAtualizada.getDescricaoSala());
        salaExistente.setValorSala(salaAtualizada.getValorSala());
        salaExistente.setQtdeComporta(salaAtualizada.getQtdeComporta());
        salaExistente.setCidade(salaAtualizada.getCidade());
        salaExistente.setEstado(salaAtualizada.getEstado());
        salaExistente.setEndereco(salaAtualizada.getEndereco());

        // Salvar a sala atualizada no banco de dados
        salasService.atualizarSala(salaExistente);

        // Redirecionar para a lista de salas após a edição
        return "redirect:/salas/listar";
    }

    @GetMapping("/excluir/{id}")
    public String excluirSala(@PathVariable Long id, Model model) {
        salasService.deletarSala(id);
        // Redirecionar para a lista de salas após a exclusão
        return "redirect:/salas/listar";
    }
}
