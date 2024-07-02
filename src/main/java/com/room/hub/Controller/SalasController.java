package com.room.hub.controller;

import com.room.hub.bean.Salas;
import com.room.hub.service.SalasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

            return "salas_criadas"; // Página para exibir o ID criado
        } catch (IOException e) {
            model.addAttribute("error", "Erro ao criar a sala.");
            return "criar_sala";
        }
    }
}

