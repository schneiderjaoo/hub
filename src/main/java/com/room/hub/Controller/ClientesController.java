package com.room.hub.controller;

import com.room.hub.model.Clientes;
import com.room.hub.service.AuthService;
import com.room.hub.service.ClienteCrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.Optional;

@Controller
public class ClientesController {

    @Autowired
    private AuthService authService;

    @Autowired
    private ClienteCrudService clienteCrudService;

    @PostMapping("/login")
    public String login(@RequestParam String usuario, @RequestParam String senha, Model model) {
        try {
            if (authService.authenticate(usuario, senha)) {
                return "redirect:/dashboard";
            } else {
                model.addAttribute("ERROR", "Senha incorreta");
                return "login";
            }
        } catch (NoSuchAlgorithmException e) {
            model.addAttribute("ERROR", "Erro ao autenticar. Tente novamente mais tarde.");
            return "login";
        } catch (Exception e) {
            model.addAttribute("ERROR", "Erro inesperado. Tente novamente mais tarde.");
            return "login";
        }
    }

    @GetMapping("/clientes")
    public String listClientes(Model model) {
        try {
            model.addAttribute("clientes", clienteCrudService.findAll());
            return "clientes";
        } catch (Exception e) {
            model.addAttribute("ERROR", "Erro ao carregar clientes. Tente novamente mais tarde.");
            return "clientes";
        }
    }

    @GetMapping("/clientes/editar/{id}")
    public String editClienteForm(@PathVariable Long id, Model model) {
        try {
            Optional<Clientes> clienteOpt = clienteCrudService.findById(id);
            if (clienteOpt.isPresent()) {
                model.addAttribute("cliente", clienteOpt.get());
                return "clienteEditar";
            } else {
                model.addAttribute("ERROR", "Cliente não encontrado.");
                return "redirect:/clientes";
            }
        } catch (Exception e) {
            model.addAttribute("ERROR", "Erro ao acessar cliente. Tente novamente mais tarde.");
            return "redirect:/clientes";
        }
    }

    @PostMapping("/clientes/editar")
    public String editCliente(@ModelAttribute Clientes cliente, Model model) {
        try {
            clienteCrudService.save(cliente);
            return "redirect:/clientes";
        } catch (Exception e) {
            model.addAttribute("ERROR", "Erro ao atualizar cliente. Tente novamente mais tarde.");
            return "clienteEditar";
        }
    }

    @GetMapping("/clientes/deletar/{id}")
    public String deleteCliente(@PathVariable Long id, Model model) {
        try {
            clienteCrudService.deleteById(id);
            return "redirect:/clientes";
        } catch (Exception e) {
            model.addAttribute("ERROR", "Erro ao deletar cliente. Tente novamente mais tarde.");
            return "clientes";
        }
    }
}
