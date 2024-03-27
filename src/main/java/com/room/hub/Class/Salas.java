package com.room.hub.Class;

import jakarta.persistence.*;

@Entity
public class Salas {
    
    @Id
    @GeneratedValue
    private long id;
    
    private String nomeSala;
    private String descricaoSala;

    public long getId() {
        return id;
    }

    public String getNomeSala() {
        return nomeSala;
    }

    public String getDescricaoSala() {
        return descricaoSala;
    }

    public void setNomeSala(String nomeSala) {
        this.nomeSala = nomeSala;
    }

    public void setDescricaoSala(String descricaoSala) {
        this.descricaoSala = descricaoSala;
    }

    public Salas(String nomeSala, String descricaoSala){
        this.nomeSala = nomeSala;
        this.descricaoSala = descricaoSala;
    }
}
