package com.room.hub.dto;

import java.time.LocalDateTime;

import org.springframework.cglib.core.Local;

import com.room.hub.model.Clientes;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClienteDTO {
    private String nome;
    private String usuario;
    private String emailUsuario;
    private String senha;
    private String cpf;
    private LocalDateTime dataCadastro;

    public ClienteDTO(Clientes cliente) {
        this.nome = cliente.getNome();
        this.usuario = cliente.getUsuario();
        this.emailUsuario = cliente.getEmailUsuario();
        this.cpf = cliente.getCpf();
        this.dataCadastro = cliente.getDataCadastro();
        this.dataCadastro = LocalDateTime.now();
    }
    //Deixado vazio para criar o contrutor vazio em outras classes
    public ClienteDTO() {}
}
