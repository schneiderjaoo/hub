package com.room.hub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.room.hub.Class.Clientes;
import com.room.hub.Class.Salas;
import com.room.hub.Repository.ClientesRepository;

@SpringBootTest
class ClientesTests {

	@Autowired
    private ClientesRepository repository;

    @Test
    public void testSave(){
        Clientes clientes = new Clientes();
        clientes.setNome("clienteUm");

        Salas salas = new Salas();
        salas.setNomeSala("SalaUm");
        salas.setDescricaoSala("bem nice essa!");
        salas.setSituacao(0);

        repository.save(clientes);
    }

}

