/* 
package com.room.hub.Class;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.*;

import org.aspectj.bridge.Message;
import org.hibernate.Session;
import org.springframework.boot.rsocket.server.RSocketServer.Transport;
 
public class EmailSender {
    private String smtpServer;
    private int port;
    private String username;
    private String password;
 
    public EmailSender(String smtpServer, int port, String username, String password) {
        this.smtpServer = smtpServer;
        this.port = port;
        this.username = username;
        this.password = password;
    }
 
    public void sendEmail(String toEmail, String subject, String messageBody) {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", smtpServer);
        props.put("mail.smtp.port", port);
 
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });
 
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(toEmail));
            message.setSubject(subject);
            message.setText(messageBody);
 
            Transport.send(message);
            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            System.out.println("Error sending email: " + e);
        }
    }
 
    public static void main(String[] args) {
        String smtpServer = "smtp-mail.outlook.com";
        int port = 587;
        String username = "vulpixcatolicasc@hotmail.com";
        String password = "vulpix2024";
 
        EmailSender sender = new EmailSender(smtpServer, port, username, password);
        sender.sendEmail("katiam2022@gmail.com", "Oi", "Boa noite!\n\n\tSalgadinho\n\nAtenciosamente,");
    }
} */