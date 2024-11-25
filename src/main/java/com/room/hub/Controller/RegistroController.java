package com.room.hub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.room.hub.model.Clientes;
import com.room.hub.model.PasswordUtils;
import com.room.hub.service.ClienteCrudService;
import java.security.NoSuchAlgorithmException;

@Controller
public class RegistroController {

    @Autowired
    private ClienteCrudService service;

    @GetMapping("/")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String register(@RequestParam String nome, @RequestParam String usuario,
                           @RequestParam String senha, @RequestParam String emailUsuario,
                           @RequestParam String cpf, Model model) {
        if (service.findByUsuario(usuario) != null) {
            model.addAttribute("ERROR", "Usuário já existe");
            return "login";
        }

        try {
            String hashedPassword = PasswordUtils.hashPassword(senha);

            Clientes cliente = new Clientes();
            cliente.Clientes(nome, usuario, hashedPassword, emailUsuario, 1, cpf);
            service.save(cliente);

            return "redirect:/login";
        } catch (NoSuchAlgorithmException e) {
            model.addAttribute("ERROR", "Erro ao registrar usuário. Tente novamente mais tarde.");
            return "login";
        }
    }
}
