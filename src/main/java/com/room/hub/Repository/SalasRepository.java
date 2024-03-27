package com.room.hub.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.room.hub.Class.Salas;

@Repository
public interface SalasRepository extends CrudRepository<Salas, Long>{
    
}
