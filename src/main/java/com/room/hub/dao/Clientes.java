package com.room.hub.dao;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String usuario;
    private String senha;

    @ManyToMany(mappedBy = "clientes")
    private Set<Salas> salas = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getUsuario() {
        return usuario;
    }
    
    public String getSenha() {
        return senha;
    }

    public void criarCliente(String nome,String usuario, String senha){
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public void alteraNomeCliente(String novoNome){
        this.nome = novoNome;
    }

    public void alteraUsuario(String novoUsuario){
        this.usuario = novoUsuario;
    }

    public void alteraSenha(String novaSenha){
        this.senha = novaSenha;
    }

    public Set<Salas> getSalas() {
        return salas;
    }

    public void setSalas(Set<Salas> salas) {
        this.salas = salas;
    }
}