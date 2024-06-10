package com.room.hub.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ReservaDeSala{
    @NotBlank
    private String nomeSala;
    private double valorSala;
    private LocalDate dataReserva;
}
