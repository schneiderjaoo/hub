package com.room.hub;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.room.hub.Class.Clientes;
import com.room.hub.Class.Salas;
import com.room.hub.Repository.ClientesRepository;
import com.room.hub.Repository.SalasRepository;

@SpringBootTest
class SalasTests {
    
    @Autowired
    private SalasRepository salasRepository;

    @Autowired
    private ClientesRepository clientesRepository;

    @Test
    public void testSave(){
        Clientes clientes = new Clientes();
        clientes.setNome("ClienteUm");

        clientesRepository.save(clientes);

        Salas salas = new Salas();
        salas.setNomeSala("SalaTeste");
        salas.setSituacao(0);
        salas.setDescricaoSit(salas.getDescricaoSit());

        salasRepository.save(salas);
    }
}