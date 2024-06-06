package com.room.hub.dao;

import java.util.*;

import com.room.hub.Interface.Classificacao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

// @Entity
// @Getter
// @NoArgsConstructor
// public class Salas implements Classificacao{
    
//     @Id
//     @GeneratedValue
//     private long id;
    
//     private String nomeSala;
//     private String descricaoSala;
//     private int situacaoSala; // Situação: 0 disponível, 1 ocupada, 2 ausente
//     private String descricaoSit;
//     private double valorSala;

//     @ManyToMany
//     private Set<Clientes> clientes = new HashSet<>();

// 	private double estrela;

//     public void estrela(double estrela) {
//         this.estrela = estrela;
//     }

//     public String defineSituacao(int situacao) {
//         if (situacao == 0) {
//             return "Disponível";
//         } else if (situacao == 1) {
//             return "Ocupada";
//         } else {
//             System.out.println("Sua sala esta ausente, adeque ela a nossos padroes para poder ser ativa novamentesss");
//             return "Ausente";
//         }
//     }

//     public void criarSalas(String nomeSala, String descricaoSala, int situacaoSala, double valorSala){
//         this.nomeSala = nomeSala;
//         this.descricaoSala = descricaoSala;
//         this.situacaoSala = situacaoSala;
//         this.descricaoSit = defineSituacao(situacaoSala);
//         this.valorSala = valorSala;
//         this.estrela = 5; //toda sala é criada com 5 estrelas
//     }

//     @Override
//     public double getClassifica() {
//         return this.estrela;
//     }

//     public void alteraNomeSala(String novoNomeSala){
//         this.nomeSala = novoNomeSala;
//     }

//     public void alteraDescricaoSala(String novaDescricaoSala){
//         this.descricaoSala = novaDescricaoSala;
//     }

//     public void alteraSituacaoSala(int situacaoSala){
//         this.situacaoSala = situacaoSala;
//     }

//     public void alteraDescricaoSituacaoSala(String situacaoDescricaoSala){
//         this.descricaoSit = situacaoDescricaoSala;
//     }

//     public void alteraValorSala(double novoValorSala){
//         this.valorSala = novoValorSala;
//     }
// }

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

    public String defineSituacao(int situacao) {
        if (situacao == 0) {
            return "Disponível";
        } else if (situacao == 1) {
            return "Ocupada";
        } else {
            System.out.println("Sua sala está ausente, adeque ela a nossos padrões para poder ser ativa novamente.");
            return "Ausente";
        }
    }

    public void criarSalas(String nomeSala, String descricaoSala, int situacaoSala, double valorSala) {
        this.nomeSala = nomeSala;
        this.descricaoSala = descricaoSala;
        this.situacaoSala = situacaoSala;
        this.descricaoSit = defineSituacao(situacaoSala);
        this.valorSala = valorSala;
        this.estrela = 5; // toda sala é criada com 5 estrelas
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

    public void alteraSituacaoSala(int situacaoSala) {
        this.situacaoSala = situacaoSala;
    }

    public void alteraDescricaoSituacaoSala(String situacaoDescricaoSala) {
        this.descricaoSit = situacaoDescricaoSala;
    }

    public void alteraValorSala(double novoValorSala) {
        this.valorSala = novoValorSala;
    }
}
