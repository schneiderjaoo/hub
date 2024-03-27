package com.room.hub.Class;

import java.util.*;
import jakarta.persistence.*;

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

    public void setSalas(Set<Salas> salas){
        this.salas = salas;
    }
}
