package com.room.hub.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.room.hub.Class.Clientes;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Long>{
    
}
