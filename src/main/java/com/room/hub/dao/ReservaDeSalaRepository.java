package com.room.hub.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.room.hub.model.ReservaDeSala;

@Repository
public interface ReservaDeSalaRepository extends CrudRepository<ReservaDeSala, Long>{
    
}
