package com.room.hub.model;

import java.util.List;

public class Financeiro{
    private static double valorTotal ;
    private static double taxa = 20;
    private static double valorFinal;
    private static int quantidadeSala;

    public static double calculaValorTotal(List<Salas> salas){
        for (Salas sala : salas){
            quantidadeSala++;
            valorTotal += sala.getValorSala();
        }
        valorFinal = valorTotal - (((taxa * quantidadeSala) / 100) * quantidadeSala);
        return valorFinal;
    }
}