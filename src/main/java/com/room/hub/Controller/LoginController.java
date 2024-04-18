package com.room.hub.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        if ("admin".equals(username) && "senha123".equals(password)) {
            return "redirect:/home";
        } else {
            model.addAttribute("error", "Usuário ou senha inválidos");
            return "login";
        }
    }

    @GetMapping("/login/home")
    public String showHomePage(Model model) {
        return "home";
    }
}
