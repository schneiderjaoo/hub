package com.room.hub.bean;

import java.time.LocalDate;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class ReservaDeSala {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Salas sala;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Clientes cliente;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private LocalDate dataCancelamento;
    private Classificacao classificacao;

    public void criarReserva(Clientes cliente, Salas sala, LocalDate dataInicio, LocalDate dataFim){
        this.cliente = cliente;
        this.sala = sala;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.classificacao = Classificacao.RESERVADO;
    }

    public void cancelarReserva(Clientes cliente, Salas sala){
        this.classificacao = Classificacao.DISPONÍVEL;
        this.dataCancelamento = LocalDate.now();
    }

    public void alterarDataReserva(LocalDate dataInicioNova, LocalDate dataFimNova){
        this.dataInicio = dataInicioNova;
        this.dataFim = dataFimNova;
    }
}
