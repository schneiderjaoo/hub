package com.room.hub.bean;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;
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
    private Date dataCadastro;
    private String emailUsuario;
    private NivelUsuario tipoUsuario;//1,2,3
    private String cpf;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Salas> salas = new HashSet<>();

    public void criarCliente(String nome, String usuario, String senha, String string, String cpf) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.dataCadastro = new Date();
        this.emailUsuario = string;
        this.tipoUsuario = tipoUsuario.padrao;
        this.cpf = cpf;
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

    public void alterarCpf(String novoCpf){
        this.cpf = novoCpf;
    }
}
