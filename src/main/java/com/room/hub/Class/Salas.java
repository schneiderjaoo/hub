package com.room.hub.Class;

import java.util.*;

import com.room.hub.Interface.Classificacao;

import jakarta.persistence.*;

@Entity
public class Salas implements Classificacao{
    
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

    public double getvalorSala(){
        return valorSala;
    }

    public long getId() {
        return id;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public String getDescricaoSala() {
        return descricaoSala;
    }

    public int getSituacao() {
        return situacaoSala;
    }

    public String getDescricaoSit() {
        return descricaoSit;
    }

    public String estrela() {
        return nomeSala;
    }

    public void estrela(double estrela) {
        this.estrela = estrela;
    }

    public String defineSituacao(int situacao) {
        if (situacao == 0) {
            return "Disponível";
        } else if (situacao == 1) {
            return "Ocupada";
        } else {
            System.out.println("Sua sala esta ausente, adeque ela a nossos padroes para poder ser ativa novamentesss");
            return "Ausente";
        }
    }

    public void criarSalas(String nomeSala, String descricaoSala, int situacaoSala, double valorSala){
        this.nomeSala = nomeSala;
        this.descricaoSala = descricaoSala;
        this.situacaoSala = situacaoSala;
        this.descricaoSit = defineSituacao(situacaoSala);
        this.valorSala = valorSala;
    }

    public Salas(String string, String string2, int i, int j) {
        //TODO Auto-generated constructor stub
    }

    public Set<Clientes> getClientes(){
        return clientes;
    }

    @Override
    public double getClassifica() {
        return this.estrela;
    }

    public void alteraNomeSala(String novoNomeSala){
        this.nomeSala = novoNomeSala;
    }

    public void alteraDescricaoSala(String novaDescricaoSala){
        this.nomeSala = novaDescricaoSala;
    }

    public void alteraSituacaoSala(String novaSituacaoSala){
        this.nomeSala = novaSituacaoSala;
    }

    public void alteraValorSala(String novoValorSala){ //caiu na inflação
        this.nomeSala = novoValorSala;
    }
}