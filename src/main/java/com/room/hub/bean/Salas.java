package com.room.hub.bean;

import java.util.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
@Entity
@Getter
@NoArgsConstructor
public class Salas{
    
    @Id
    @GeneratedValue
    private long id;
    @NotNull
    private String nomeSala;
    private String descricaoSala;
    @NotNull
    private double valorSala;
    private Classificacao classSala;

    @ManyToMany
    @JoinTable(
        name = "SALAS_CLIENTES",
        joinColumns = @JoinColumn(name = "sala_id"),
        inverseJoinColumns = @JoinColumn(name = "cliente_id")
    )
    
    private Set<Clientes> clientes = new HashSet<>();

    private double estrela;

    public void estrela(double estrela) {
        this.estrela = estrela;
    }

    public void criarSalas(String nomeSala, String descricaoSala, double valorSala) {
        this.nomeSala = nomeSala;
        this.descricaoSala = descricaoSala;
        this.valorSala = valorSala;
        this.estrela = 5; // toda sala é criada com 5 estrelas
        this.classSala = Classificacao.RESERVADO;
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
}
