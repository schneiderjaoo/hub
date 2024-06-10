package com.room.hub.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.room.hub.bean.Clientes;

@Repository
public interface ClientesRepository extends CrudRepository<Clientes, Long>{
    
}
