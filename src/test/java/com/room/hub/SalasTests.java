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
        cliente.setNome("ClienteUm");
        clientesRepository.save(cliente);

        Salas sala = new Salas();
        sala.setNomeSala("SalaTeste");
        sala.setSituacao(0);
        sala.setDescricaoSit(sala.getDescricaoSit());
        salasRepository.save(sala);

        sala.setSituacao(1); //Ocupado
        salasRepository.save(sala);

        Salas salaEditada = salasRepository.findById(sala.getId()).orElse(null); //buscando sala do bd para verificar se foi alterada
        assertNotNull(salaEditada);
        assertEquals(1, salaEditada.getSituacao());

        salasRepository.deleteById(sala.getId());
        Salas salasExclusão = salasRepository.findById(sala.getId()).orElse(null);//método para exluir salas
        assertNull(salasExclusão);//se não for nullo falha o teste semelhante aos assets a cima
    }
}
