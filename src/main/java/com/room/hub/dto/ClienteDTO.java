package com.room.hub.dto;

import java.time.LocalDateTime;

import com.room.hub.model.Clientes;
import com.room.hub.model.NivelDeUsuario;
import lombok.Getter;
import lombok.Setter;

/**
 * Data Transfer Object (DTO) para a entidade Clientes.
 * Usado para transportar dados de Clientes sem expor o modelo diretamente.
 */
@Getter
@Setter
public class ClienteDTO {
    private String nome;
    private String usuario;
    private String emailUsuario;
    private String senha;
    private String cpf;
    private LocalDateTime dataCadastro;
    private NivelDeUsuario tipoUsuario;

    /**
     * Construtor baseado no modelo Clientes.
     * @param cliente Instância de Clientes para conversão em DTO.
     */
    public ClienteDTO(Clientes cliente) {
        this.nome = cliente.getNome();
        this.usuario = cliente.getUsuario();
        this.emailUsuario = cliente.getEmailUsuario();
        this.senha = cliente.getSenha();//Rever a regra de negócio para não expor a senha
        this.cpf = cliente.getCpf();
        this.dataCadastro = cliente.getDataCadastro();
        this.tipoUsuario = cliente.getTipoUsuario();
    }

    
    //Construtor vazio necessário para frameworks e uso genérico.
    public ClienteDTO() {}
}
