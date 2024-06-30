package com.room.hub.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String usuario;
    private String senha;
    private int chave;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Salas> salas = new HashSet<>();

    public void criarCliente(String nome, String usuario, String senha, int chave) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.chave = chave;
    }

    public void alteraNomeCliente(String novoNome) {
        this.nome = novoNome;
    }

    public void alteraUsuario(String novoUsuario) {
        this.usuario = novoUsuario;
    }

    public void alteraSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public void setSalas(Set<Salas> salas) {
        this.salas = salas;
    }
}
