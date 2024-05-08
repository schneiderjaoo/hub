package com.room.hub.Class;

public class Financeiro extends Salas{
    private static double valorTotal ;
    private static double taxa = 20;
    private static double valorFinal;
    private static int quantidadeSala;

    public static double calculaValorTotal(Salas[] salas){
        for (Salas sala : salas){
            quantidadeSala++;
            valorTotal += sala.getvalorSala();
        }
        valorFinal = valorTotal - ((taxa / 100) * quantidadeSala);
        return valorFinal;
    }

    public static void main(String[] args) {
        Salas[] salas = {
            new Salas("descricaoSala", "descricaoSala", 5, 100),
            new Salas("descricaoSala", "descricaoSala", 5, 300),
            new Salas("descricaoSala", "descricaoSala", 5, 200)
        };
        calculaValorTotal(salas);
        System.out.println("Valor total "+valorFinal);
    }
}