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
        salas.setDescricaoSit(salas.getDescricaoSit());

        repository.save(clientes);

        clientes.setNome("Trocado");//editado cliente
        repository.save(clientes);

        Clientes clientesEditado = repository.findById(clientes.getId()).orElse(null); //buscando cliente do bd para verificar se foi alterada
        assertNotNull(clientesEditado);
        assertEquals("Trocado", clientesEditado.getNome());

        repository.deleteById(clientes.getId());
        Clientes clientesExclusão = repository.findById(clientes.getId()).orElse(null);//método para exluir clientes
        assertNull(clientesExclusão);//se não for nullo falha o teste semelhante aos assets a cima
    }

}

