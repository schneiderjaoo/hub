package com.room.hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.room.hub.bean.Clientes;
import com.room.hub.service.ClientesService;

@Controller
public class RegistroController {

    @Autowired
    private ClientesService service;

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String nome, @RequestParam String usuario, @RequestParam String senha, Model model) {
        if (service.findByUsuario(usuario) != null) {
            model.addAttribute("ERROR", "Usuário já existe");
            return "register";
        }

        Clientes cliente = new Clientes();
        cliente.criarCliente(nome, usuario, senha, 0);
        service.save(cliente);

        return "redirect:/login";
    }
}
