package com.room.hub.service;

import java.security.NoSuchAlgorithmException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.room.hub.model.Clientes;
import com.room.hub.model.PasswordUtils;

@Service
public class AuthService {

    @Autowired
    private ClienteCrudService clientesService;

    public boolean authenticate(String usuario, String senha) throws NoSuchAlgorithmException {
        Clientes cliente = clientesService.findByUsuario(usuario);
        if (cliente != null) {
            String hashedPassword = cliente.getSenha();
            return PasswordUtils.verifyPassword(senha, hashedPassword);
        }
        return false;
    }
}

