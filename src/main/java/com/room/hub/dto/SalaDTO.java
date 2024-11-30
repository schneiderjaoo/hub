package com.room.hub.dto;

import com.room.hub.model.Salas;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SalaDTO {
    private Long id;
    private String nomeSala;
    private String descricaoSala;
    private double valorSala;
    private Integer qtdeComporta;
    private String cidade;
    private String estado;
    private String endereco;
    private double estrela;

    // Construtor que inicializa os campos com base em um objeto Salas
    public SalaDTO(Salas sala) {
        this.id = sala.getId();
        this.nomeSala = sala.getNomeSala();
        this.descricaoSala = sala.getDescricaoSala();
        this.valorSala = sala.getValorSala();
        this.qtdeComporta = sala.getQtdeComporta();
        this.cidade = sala.getCidade();
        this.estado = sala.getEstado();
        this.endereco = sala.getEndereco();
        this.estrela = sala.getEstrela();
    }

    // Construtor vazio para outras utilizações (ex.: frameworks ou APIs)
    public SalaDTO() {}
}
