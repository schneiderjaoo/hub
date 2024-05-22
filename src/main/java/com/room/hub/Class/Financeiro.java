package com.room.hub.Class;

import java.util.List;

public class Financeiro{
    private static double valorTotal ;
    private static double taxa = 20;
    private static double valorFinal;
    private static int quantidadeSala;

    public static double calculaValorTotal(List<Salas> salas){
        for (Salas sala : salas){
            quantidadeSala++;
            valorTotal += sala.getvalorSala();
        }
        valorFinal = valorTotal - ((taxa / 100) * quantidadeSala);
        return valorFinal;
    }

    public static void main(String[] args) {
        Salas sala1 = new Salas();
        sala1.criarSalas("null", "null", 2, 10);
        Salas sala2 = new Salas();
        sala2.criarSalas("null", "null", 2, 100);
        Salas sala3 = new Salas();
        sala3.criarSalas("null", "null", 2, 1000);
        
        List<Salas> salas = List.of(sala1, sala2, sala3);
        calculaValorTotal(salas);
        System.out.println("Valor total: " + valorFinal);
    }
}