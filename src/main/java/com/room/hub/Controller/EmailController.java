package com.room.hub.controller;

import com.room.hub.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.File;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @PostMapping("/enviar")
    public String enviarEmail(@RequestParam String destinatario, @RequestParam String assunto,
                              @RequestParam String corpo, @RequestParam String caminhoDoArquivo) throws jakarta.mail.MessagingException {
        try {
            File arquivo = new File(caminhoDoArquivo);
            emailService.enviarEmailComAnexo(destinatario, assunto, corpo, arquivo);
            return "E-mail enviado com sucesso!";
        } catch (MessagingException e) {
            return "Erro ao enviar e-mail: " + e.getMessage();
        }
    }
}
