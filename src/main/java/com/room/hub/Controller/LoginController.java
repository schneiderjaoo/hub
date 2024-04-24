package com.room.hub.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")
    public String loginSubmit(LoginForm loginForm) {
        // Aqui você pode implementar a lógica de autenticação, por exemplo, verificar se o usuário e senha estão corretos
        // Se a autenticação for bem-sucedida, redirecione para a página home
        // Caso contrário, redirecione de volta para a página de login com uma mensagem de erro
        return "redirect:/home";
    }

    // Classe auxiliar para representar o formulário de login
    public static class LoginForm {
        private String username;
        private String password;

        // Getters e setters
        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
