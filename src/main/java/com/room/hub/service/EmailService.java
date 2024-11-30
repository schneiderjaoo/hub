package com.room.hub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender emailSender;

    public void enviarEmailComAnexo(String destinatario, String assunto, String corpo, File arquivoAnexo) throws MessagingException, jakarta.mail.MessagingException {
        // Verifica se o arquivo é nulo antes de tentar anexá-lo
        if (arquivoAnexo == null || !arquivoAnexo.exists()) {
            throw new MessagingException("O arquivo de anexo não foi encontrado ou é inválido.");
        }

        // Criação da mensagem MIME
        jakarta.mail.internet.MimeMessage message = emailSender.createMimeMessage();
        
        // Helper para facilitar a criação do e-mail com anexo
        MimeMessageHelper helper = new MimeMessageHelper(message, true);
        helper.setTo(destinatario);
        helper.setSubject(assunto);
        helper.setText(corpo);
        
        // Adiciona o anexo
        helper.addAttachment(arquivoAnexo.getName(), arquivoAnexo);

        emailSender.send(message);
    }
}
