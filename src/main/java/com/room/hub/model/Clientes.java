package com.room.hub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
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

    @NotNull
    private String nome;

    @NotNull
    private String usuario;

    @NotNull
    private String senha;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCadastro;

    @NotNull
    @Email
    private String emailUsuario;

    @Enumerated(EnumType.STRING)
    private NivelUsuario tipoUsuario; // Tipo de usuário (1, 2, 3)

    @NotNull
    private String cpf;

    @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Salas> salas = new HashSet<>();

    // Construtor para inicialização
    public Clientes(String nome, String usuario, String senha, String emailUsuario, NivelUsuario tipoUsuario, String cpf) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.emailUsuario = emailUsuario;
        this.tipoUsuario = tipoUsuario;
        this.cpf = cpf;
        this.dataCadastro = new Date();
    }

    // Método para alterar o nome do cliente
    public void alteraNomeCliente(String novoNome) {
        this.nome = novoNome;
    }

    // Método para alterar a senha
    public void alteraSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    // Método para adicionar uma sala
    public void adicionarSala(Salas sala) {
        this.salas.add(sala);
        sala.getClientes().add(this);
    }    

    // Método para remover uma sala
    public void removerSala(Salas sala) {
        this.salas.remove(sala);
        sala.setClientes(null);
    }
}
