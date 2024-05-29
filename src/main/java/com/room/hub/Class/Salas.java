package com.room.hub.Class;

import java.util.HashSet;
import java.util.Set;

import com.room.hub.Interface.Classificacao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Salas implements Classificacao {

    @Id
    @GeneratedValue
    private long id;

    private String nomeSala;
    private String descricaoSala;
    private int situacaoSala; // Situação: 0 disponível, 1 ocupada, 2 ausente
    private String descricaoSit;
    private double valorSala;

    @ManyToMany
    private Set<Clientes> clientes = new HashSet<>();

    private double estrela;

    public void criarSalas(String nomeSala, String descricaoSala, int situacaoSala, double valorSala) {
        this.nomeSala = nomeSala;
        this.descricaoSala = descricaoSala;
        this.situacaoSala = situacaoSala;
        this.descricaoSit = defineSituacao(situacaoSala);
        this.valorSala = valorSala;
        this.estrela = 5; // Toda sala é criada com 5 estrelas
    }

    public String defineSituacao(int situacao) {
        switch (situacao) {
            case 0:
                return "Disponível";
            case 1:
                return "Ocupada";
            case 2:
                return "Ausente";
            default:
                return "Situação inválida";
        }
    }

    @Override
    public double getClassifica() {
        return this.estrela;
    }

    public void alteraNomeSala(String novoNomeSala) {
        this.nomeSala = novoNomeSala;
    }

    public void alteraDescricaoSala(String novaDescricaoSala) {
        this.descricaoSala = novaDescricaoSala;
    }

    public void alteraSituacaoSala(int novaSituacaoSala) {
        this.situacaoSala = novaSituacaoSala;
        this.descricaoSit = defineSituacao(novaSituacaoSala);
    }

    public void alteraValorSala(double novoValorSala) {
        this.valorSala = novoValorSala;
    }

    public void avaliar(double novaEstrela) {
        this.estrela = novaEstrela;
    }
}
