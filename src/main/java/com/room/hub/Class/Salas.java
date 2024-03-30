package com.room.hub.Class;

import java.util.*;

import jakarta.persistence.*;

@Entity
public class Salas {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String nomeSala;
    private String descricaoSala;
    private int situacao; // Situação: 0 disponível, 1 ocupada, 2 ausente
    private String descricaoSit;

    @ManyToMany
    private Set<Clientes> clientes = new HashSet<>();

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
        return situacao;
    }

    public String getDescricaoSit() {
        return descricaoSit;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public void setDescricaoSala(String descricaoSala) {
        this.descricaoSala = descricaoSala;
    }

    public void setSituacao(int situacao) {
        this.situacao = situacao;
        this.descricaoSit = defineSituacao(situacao); // Corrigido para setar a descricaoSit corretamente
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

    public Salas(String nomeSala, String descricaoSala, int situacao){
        this.nomeSala = nomeSala;
        this.descricaoSala = descricaoSala;
        this.situacao = situacao;
        this.descricaoSit = defineSituacao(situacao);
    }

    public Salas() {
        //TODO Auto-generated constructor stub
    }

    public Set<Clientes> getClientes(){
        return clientes;
    }
}