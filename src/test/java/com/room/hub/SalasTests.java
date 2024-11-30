package com.room.hub;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.room.hub.model.Clientes;
import com.room.hub.model.NivelDeUsuario;
import com.room.hub.model.Salas;

class SalasTest {

    private Salas sala;
    private Clientes cliente;

    @BeforeEach
    void setUp() {
        sala = new Salas();
        cliente = new Clientes(
                "Ana Souza",
                "anasouza",
                "senha123",
                "ana.souza@example.com",
                NivelDeUsuario.ADMIN,
                "98765432100"
        );
    }

    @Test
    void testCriarSalas() {
        sala.criarSalas(
                "Sala de Conferências",
                "Uma sala ampla com capacidade para 50 pessoas.",
                500.0,
                50,
                "São Paulo",
                "SP",
                "Rua das Flores, 123"
        );

        assertEquals("Sala de Conferências", sala.getNomeSala());
        assertEquals("Uma sala ampla com capacidade para 50 pessoas.", sala.getDescricaoSala());
        assertEquals(500.0, sala.getValorSala());
        assertEquals(50, sala.getQtdeComporta());
        assertEquals("São Paulo", sala.getCidade());
        assertEquals("SP", sala.getEstado());
        assertEquals("Rua das Flores, 123", sala.getEndereco());
    }

    @Test
    void testAssociarCliente() {
        // Criação de um cliente
        cliente = new Clientes(
                "João Silva",
                "joaosilva",
                "senha123",
                "joao.silva@example.com",
                NivelDeUsuario.CLIENTE,
                "12345678900"
        );
        // Criação de uma sala
        sala = new Salas();
        sala.setNomeSala("Sala de Reuniões");
    
        // Antes da associação
        int clientesSizeBefore = sala.getClientes().size();
    
        // Associando o cliente à sala
        sala.associarCliente(cliente);
    
        // Verificando se a sala foi adicionada ao cliente
        assertEquals(clientesSizeBefore + 1, sala.getClientes().size(), "A sala não foi associada ao cliente");
    
        // Verificando se o cliente foi adicionado à sala
        assertTrue(sala.getClientes().contains(cliente), "O cliente não foi associado à sala");
    }
    
    @Test
    void testDesassociarCliente() {
        // Criação de um cliente
        cliente = new Clientes(
                "João Silva",
                "joaosilva",
                "senha123",
                "joao.silva@example.com",
                NivelDeUsuario.CLIENTE,
                "12345678900"
        );
        // Criação de uma sala
        sala = new Salas();
        sala.setNomeSala("Sala de Reuniões");
    
        // Associando o cliente à sala
        sala.associarCliente(cliente);
    
        // Verificando a associação
        assertTrue(sala.getClientes().contains(cliente), "O cliente não foi associado à sala");
    
        // Antes da desassociação
        int clientesSizeBefore = sala.getClientes().size();
    
        // Desassociando o cliente da sala
        sala.desassociarCliente(cliente);
    
        // Verificando se a sala foi removida do cliente
        assertEquals(clientesSizeBefore - 1, sala.getClientes().size(), "A sala não foi removida do cliente");
    
        // Verificando se o cliente foi removido da sala
        assertFalse(sala.getClientes().contains(cliente), "O cliente não foi removido da sala");
    }
    
}
