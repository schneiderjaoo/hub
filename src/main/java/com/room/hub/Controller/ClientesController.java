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
}
