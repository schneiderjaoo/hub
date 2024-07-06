package com.room.hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.room.hub.bean.Clientes;
import com.room.hub.bean.NivelUsuario;
import com.room.hub.service.ClientesService;

import java.util.Optional;

@Controller
public class ClientesController {

    @Autowired
    private ClientesService service;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String password, Model model) {
        Clientes cliente = service.findByUsuario(usuario);
        if (cliente != null && cliente.getSenha().equals(password)) {
            return "redirect:/dashboard";
        }
        model.addAttribute("ERROR", "Usuário ou senha inválidos");
        return "login";
    }

    @GetMapping("/dashboard")
    public String dashboard() {
        return "home";
    }

    @GetMapping("/clientes")
    public String listClientes(Model model) {
        model.addAttribute("clientes", service.findAll());
        return "clientes";
    }

    @GetMapping("/clientes/editar/{id}")
    public String editClienteForm(@PathVariable Long id, Model model) {
        Optional<Clientes> clienteOpt = service.findById(id);
        if (clienteOpt.isPresent()) {
            model.addAttribute("cliente", clienteOpt.get());
            model.addAttribute("tiposUsuario", NivelUsuario.values());
            return "clienteEditar";
        } else {
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/editar")
    public String editCliente(@ModelAttribute Clientes cliente) {
        service.update(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/clientes/deletar/{id}")
    public String deleteCliente(@PathVariable Long id) {
        service.deleteById(id);
        return "redirect:/clientes";
    }
}
