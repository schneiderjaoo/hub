package com.room.hub.controller;

import com.room.hub.bean.Clientes;
import com.room.hub.bean.Salas;
import com.room.hub.service.ClientesService;
import com.room.hub.service.SalasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/relacionamento")
public class RelacionamentoController {

    @Autowired
    private ClientesService clientesService;

    @Autowired
    private SalasService salasService;

    @GetMapping("/listar")
    public String listarClientesESalas(Model model) {
        List<Clientes> clientes = clientesService.findAll();
        List<Salas> salas = salasService.listarSalas();
        model.addAttribute("clientes", clientes);
        model.addAttribute("salas", salas);
        return "relacionar_salas";
    }

    @PostMapping("/relacionar")
    public String relacionarSalaCliente(@RequestParam("clienteId") Long clienteId,
            @RequestParam("salaId") Long salaId,
            Model model) {
        try {
            clientesService.relacionarClienteSala(clienteId, salaId);
            return "redirect:/relacionamento/listar";
        } catch (Exception e) {
            model.addAttribute("error", "Erro ao relacionar sala e cliente: " + e.getMessage());
            return "relacionar_salas";
        }
    }
}
