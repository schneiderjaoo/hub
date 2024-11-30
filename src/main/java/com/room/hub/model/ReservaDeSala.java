package com.room.hub.model;

import java.time.LocalDate;
import java.util.Date;

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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sala_id", nullable = false)
    private Salas sala;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private Clientes cliente;

    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Date dataCancelamento;
    private Classificacao classificacao;
    private String motivoCancelamento;
    private boolean cancelada;

    public void criarReserva(Clientes cliente, Salas sala, LocalDate dataInicio, LocalDate dataFim){
        this.cliente = cliente;
        this.sala = sala;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.classificacao = Classificacao.RESERVADO;
    }

    public void cancelarReserva(String motivo, LocalDate localDate) {
        this.motivoCancelamento = motivo;
        this.dataCancelamento = new Date();
        this.cancelada = true;
        this.classificacao = Classificacao.CANCELADO;
    }

    public void alterarDataReserva(LocalDate dataInicioNova, LocalDate dataFimNova){
        this.dataInicio = dataInicioNova;
        this.dataFim = dataFimNova;
    }
}
