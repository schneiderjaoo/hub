package com.room.hub.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Salas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String nomeSala;

    private String descricaoSala;

    @NotNull
    private double valorSala;

    @NotNull
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer qtdeComporta;

    private String cidade;
    private String estado;
    private String endereco;

    @ManyToMany
    @JoinTable(
            name = "SALAS_CLIENTES",
            joinColumns = @JoinColumn(name = "sala_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private Set<Clientes> clientes = new HashSet<>();

    private double estrela = 5; // Toda sala é criada com 5 estrelas por padrão

    public void criarSalas(String nomeSala, String descricaoSala, double valorSala, Integer qtdeComporta, String cidade, String estado, String endereco) {
        this.nomeSala = nomeSala;
        this.descricaoSala = descricaoSala;
        this.valorSala = valorSala;
        this.qtdeComporta = qtdeComporta;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
    }

    public void alteraNomeSala(String novoNomeSala) {
        this.nomeSala = novoNomeSala;
    }

    public void alteraDescricaoSala(String novaDescricaoSala) {
        this.descricaoSala = novaDescricaoSala;
    }

    public void alteraValorSala(double novoValorSala) {
        this.valorSala = novoValorSala;
    }

    public void alteraQtdeComporta(Integer novaQtdeComporta) {
        this.qtdeComporta = novaQtdeComporta;
    }

    public void associarCliente(Clientes cliente) {
        if (cliente != null) {
            this.clientes.add(cliente);
            cliente.getSalas().add(this);
        }
    }

    public void desassociarCliente(Clientes cliente) {
        if (cliente != null) {
            this.clientes.remove(cliente);
            cliente.getSalas().remove(this);
        }
    }
}
