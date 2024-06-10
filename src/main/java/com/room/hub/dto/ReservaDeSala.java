package com.room.hub.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservaDeSala{
    @NotBlank
    private Double valorSala;
    private LocalDate dataReservaInicio;
    private LocalFate dataReservaFim;
    private Salas sala;
    private Clientes cliente;

    

    public void reservarSala(){
    
    }

}
