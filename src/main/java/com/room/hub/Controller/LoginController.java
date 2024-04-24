package com.room.hub.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
<<<<<<< HEAD
=======
import org.springframework.web.bind.annotation.RequestParam;
>>>>>>> f57edf6409094ec8a4998ec845d0fbf355e253c1

@Controller
public class LoginController {

    @GetMapping("/login")
<<<<<<< HEAD
    public String loginForm(Model model) {
        model.addAttribute("loginForm", new LoginForm());
=======
    public String showLoginForm(Model model) {
>>>>>>> f57edf6409094ec8a4998ec845d0fbf355e253c1
        return "login";
    }

    @PostMapping("/login")
<<<<<<< HEAD
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
=======
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
>>>>>>> f57edf6409094ec8a4998ec845d0fbf355e253c1
    }
}
