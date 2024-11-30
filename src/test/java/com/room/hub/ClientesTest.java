package com.room.hub;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.room.hub.model.Clientes;
import com.room.hub.model.NivelDeUsuario;
import com.room.hub.model.Salas;

public class ClientesTest {

    private Clientes cliente;
    private Salas sala;

    @BeforeEach
    void setUp() {
        cliente = new Clientes(
                "João Silva",
                "joaosilva",
                "senha123",
                "joao.silva@example.com",
                NivelDeUsuario.CLIENTE,
                "12345678900"
        );
        sala = new Salas();
        sala.setNomeSala("Sala de Reuniões");
    }
    

    @Test
    void testConstrutor() {
        assertNotNull(cliente);
        assertEquals("João Silva", cliente.getNome());
        assertEquals("joaosilva", cliente.getUsuario());
        assertEquals("senha123", cliente.getSenha());
        assertEquals("joao.silva@example.com", cliente.getEmailUsuario());
        assertEquals(NivelDeUsuario.CLIENTE, cliente.getTipoUsuario());
        assertEquals("12345678900", cliente.getCpf());
        assertNotNull(cliente.getDataCadastro());
        assertTrue(cliente.getSalas().isEmpty());
    }

    @Test
    void testAlteraNomeCliente() {
        cliente.alteraNomeCliente("Maria Oliveira");
        assertEquals("Maria Oliveira", cliente.getNome());
    }

    @Test
    void testAlteraSenha() {
        cliente.alteraSenha("novaSenha456");
        assertEquals("novaSenha456", cliente.getSenha());
    }

    @Test
    void testAdicionarSala() {
        cliente.adicionarSala(sala);
        assertTrue(cliente.getSalas().contains(sala));
        assertTrue(sala.getClientes().contains(cliente));
    }

    @Test
    void testRemoverSala() {
        cliente.adicionarSala(sala);
        cliente.removerSala(sala);
        assertFalse(cliente.getSalas().contains(sala));
        assertFalse(sala.getClientes().contains(cliente));
    }
}

