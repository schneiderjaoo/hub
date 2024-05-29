package com.room.hub.Class;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String usuario;
    private String senha;

    @ManyToMany(mappedBy = "clientes")
    private Set<Salas> salas = new HashSet<>();

    public void criarCliente(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }

    public void alteraNomeCliente(String novoNome) {
        this.nome = novoNome;
    }

    public void alterarUsuario(String novoUsuario) {
        this.usuario = novoUsuario;
    }

    public void alterarSenha(String novaSenha) {
        this.senha = novaSenha;
    }
}
