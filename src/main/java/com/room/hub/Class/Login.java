package com.room.hub.Class;

public class Login extends Clientes{

    public Login(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public boolean authenticate() {
        return "admin".equals(nome) && "senha123".equals(senha);
    }
}

