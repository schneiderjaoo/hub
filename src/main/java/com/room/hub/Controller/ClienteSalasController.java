package com.room.hub.controller;

import com.room.hub.model.Clientes;
import com.room.hub.model.Salas;
import com.room.hub.service.ClienteCrudService;
import com.room.hub.service.SalasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class ClienteSalasController {

    @Autowired
    private ClienteCrudService clientesService;

    @Autowired
    private SalasService salasService;

    @GetMapping("/reserva/{salaId}")
    public String reservaForm(@PathVariable Long salaId, Model model) {
        Salas sala = salasService.encontrarPorId(salaId);
        if (sala == null) {
            model.addAttribute("error", "Sala não encontrada.");
            return "redirect:/salas/listar";
        }

        List<Clientes> clientes = clientesService.listarClientes();
        model.addAttribute("sala", sala);
        model.addAttribute("clientes", clientes);

        return "reserva";
    }

    @PostMapping("/associar/{clienteId}/{salaId}")
    public String associarCliente(@PathVariable Long clienteId, @PathVariable Long salaId, Model model) {
        Clientes cliente = clientesService.encontrarPorId(clienteId);
        Salas sala = salasService.encontrarPorId(salaId);

        if (cliente == null || sala == null) {
            model.addAttribute("error", "Cliente ou Sala não encontrados.");
            return "redirect:/salas/listar";
        }

        sala.associarCliente(cliente);
        salasService.atualizarSala(sala);

        return "redirect:/salas/listar";
    }

    @PostMapping("/desassociar/{clienteId}/{salaId}")
    public String desassociarCliente(@PathVariable Long clienteId, @PathVariable Long salaId, Model model) {
        Clientes cliente = clientesService.encontrarPorId(clienteId);
        Salas sala = salasService.encontrarPorId(salaId);

        if (cliente == null || sala == null) {
            model.addAttribute("error", "Cliente ou Sala não encontrados.");
            return "redirect:/salas/listar";
        }

        sala.desassociarCliente(cliente);
        salasService.atualizarSala(sala);

        return "redirect:/salas/listar";
    }
}
