package com.room.hub.dto;

import java.time.LocalDate;
import java.util.Date;

import com.room.hub.model.Classificacao;
import com.room.hub.model.Clientes;
import com.room.hub.model.Salas;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReservaDeSalaDTO {
    private Long id;
    private Salas sala;
    private Clientes cliente;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Date dataCancelamento;
    private Classificacao classificacao;
    private String motivoCancelamento;
    private boolean cancelada;
}
