package com.room.hub.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Email;
import java.time.LocalDateTime;
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

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @NotNull
    @Email
    private String emailUsuario;

    @Enumerated(EnumType.STRING)
    private NivelDeUsuario tipoUsuario;

    @NotNull
    private String cpf;

    @ManyToMany(mappedBy = "clientes", cascade = CascadeType.PERSIST)
    private Set<Salas> salas = new HashSet<>();

    public Clientes(String nome, String usuario, String senha, String emailUsuario, NivelDeUsuario tipoUsuario, String cpf) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.emailUsuario = emailUsuario;
        this.tipoUsuario = tipoUsuario;
        this.cpf = cpf;
        this.dataCadastro = LocalDateTime.now();
    }

    public void alteraNomeCliente(String novoNome) {
        this.nome = novoNome;
    }

    public void alteraSenha(String novaSenha) {
        this.senha = novaSenha;
    }

    public void adicionarSala(Salas sala) {
        this.salas.add(sala);
        sala.getClientes().add(this);
    }

    public void removerSala(Salas sala) {
        this.salas.remove(sala);
        sala.getClientes().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Clientes clientes = (Clientes) o;
        return id != null && id.equals(clientes.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
