package com.room.hub.bean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Type;

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

    @NotNull(message = "O nome da sala é obrigatório")
    private String nomeSala;

    private String descricaoSala;

    @NotNull(message = "O valor da sala é obrigatório")
    private double valorSala;

    @NotNull(message = "A quantidade de comportas é obrigatória")
    @Column(nullable = false, columnDefinition = "integer default 0")
    private Integer qtdeComporta;

    private String cidade;
    private String estado;
    private String endereco;

    @Lob
    private byte[] imagem;

    @ManyToMany
    @JoinTable(
            name = "SALAS_CLIENTES",
            joinColumns = @JoinColumn(name = "sala_id"),
            inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    private Set<Clientes> clientes = new HashSet<>();

    private double estrela = 5; // Toda sala é criada com 5 estrelas por padrão

    // Construtor completo para inicialização fácil
    public Salas(String nomeSala, String descricaoSala, double valorSala, Integer qtdeComporta, String cidade, String estado, String endereco, byte[] imagem) {
        this.nomeSala = nomeSala;
        this.descricaoSala = descricaoSala;
        this.valorSala = valorSala;
        this.qtdeComporta = qtdeComporta;
        this.cidade = cidade;
        this.estado = estado;
        this.endereco = endereco;
        this.imagem = imagem;
    }

    // Métodos de alteração simplificados
    public void alteraNomeSala(String novoNomeSala) {
        this.nomeSala = novoNomeSala;
    }

    public void alteraDescricaoSala(String novaDescricaoSala) {
        this.descricaoSala = novaDescricaoSala;
    }

    public void alteraValorSala(double novoValorSala) {
        this.valorSala = novoValorSala;
    }
}
