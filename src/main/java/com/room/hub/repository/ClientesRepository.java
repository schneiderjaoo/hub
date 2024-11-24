package com.room.hub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.room.hub.model.Clientes;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Long>{
    Clientes findByUsuario(String usuario);
}
