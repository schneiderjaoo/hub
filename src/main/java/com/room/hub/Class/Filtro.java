package com.room.hub.Class;

import com.room.hub.Interface.Classificacao;

public class Filtro {
    public void filtra(Classificacao classificavel){
        if (classificavel.getClassifica() >= 4)
            System.out.println("Está entre os preferidos do momento!");
        else if (classificavel.getClassifica() >= 2)
            System.out.println("Muito bem avaliado!");
        else {
            System.out.println("Ausente.");
            if (classificavel instanceof Salas) {
                Salas sala = (Salas) classificavel;
                sala.setSituacao(2);
            }
        }
    }
}
