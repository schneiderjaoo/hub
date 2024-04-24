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

    @ManyToMany
    private Set<Clientes> clientes = new HashSet<>();

	private double estrela;

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

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public void setDescricaoSala(String descricaoSala) {
        this.descricaoSala = descricaoSala;
    }

    public void setSituacao(int situacaoSala) {
        this.situacaoSala = situacaoSala;
        this.descricaoSit = defineSituacao(situacaoSala); // Corrigido para setar a descricaoSit corretamente
    }

    public void setDescricaoSit(String descricaoSit) {
        this.descricaoSit = descricaoSit;
    }

    public String defineSituacao(int situacao) {
        if (situacao == 0) {
            return "Disponível";
        } else if (situacao == 1) {
            return "Ocupada";
        } else {
            return "Ausente";
        }
    }

    public Salas(String nomeSala, String descricaoSala, int situacaoSala){
        this.nomeSala = nomeSala;
        this.descricaoSala = descricaoSala;
        this.situacaoSala = situacaoSala;
        this.descricaoSit = defineSituacao(situacaoSala);
    }

    public Salas() {
        //TODO Auto-generated constructor stub
    }

    public Set<Clientes> getClientes(){
        return clientes;
    }

    @Override
    public double getClassifica() {
        return this.estrela;
    }
}