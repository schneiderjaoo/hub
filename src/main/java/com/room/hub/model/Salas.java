package com.room.hub.model;

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

    // Método para associar um cliente à sala (sem duplicação)
    public void associarCliente(Clientes cliente) {
        if (cliente != null && !this.clientes.contains(cliente)) {
            this.clientes.add(cliente);
            cliente.getSalas().add(this);
        }
    }

    // Método para desassociar um cliente da sala
    public void desassociarCliente(Clientes cliente) {
        if (cliente != null && this.clientes.contains(cliente)) {
            this.clientes.remove(cliente);
            cliente.getSalas().remove(this);
        }
    }
}
