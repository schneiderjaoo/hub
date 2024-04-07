package com.room.hub.Class;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Clientes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @ManyToMany(mappedBy = "clientes")
    private Set<Salas> salas = new HashSet<>();

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Salas> getSalas() {
        return salas;
    }

    public void setSalas(Set<Salas> salas) {
        this.salas = salas;
    }
}