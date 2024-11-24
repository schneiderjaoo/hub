package com.room.hub.dto;

import com.room.hub.model.Clientes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private String nome;
    private String usuario;
    private String emailUsuario;

    public ClienteDTO(Clientes cliente) {
        this.nome = cliente.getNome();
        this.usuario = cliente.getUsuario();
        this.emailUsuario = cliente.getEmailUsuario();
    }
    //Deixado vazio para criar o contrutor vazio em outras classes
    public ClienteDTO() {}
}
