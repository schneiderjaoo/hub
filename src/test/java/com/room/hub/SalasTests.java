package com.room.hub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

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
    public void testSaveAndEdit(){
        Clientes cliente = new Clientes();
        cliente.alteraNomeCliente("ClienteUm");
        clientesRepository.save(cliente);

        Salas sala = new Salas();
        sala.alteraNomeSala("SalaTeste");
        sala.defineSituacao(0);
        salasRepository.save(sala);

        sala.defineSituacao(1); //Ocupado
        salasRepository.save(sala);

        Salas salaEditada = salasRepository.findById(sala.getId()).orElse(null); //buscando sala do bd para verificar se foi alterada
        assertNotNull(salaEditada);

        salasRepository.deleteById(sala.getId());
        Salas salasExclusão = salasRepository.findById(sala.getId()).orElse(null);//método para exluir salas
    }
}
