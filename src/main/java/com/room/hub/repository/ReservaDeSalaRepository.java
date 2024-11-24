package com.room.hub.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.room.hub.model.ReservaDeSala;

@Repository
public interface ReservaDeSalaRepository extends CrudRepository<ReservaDeSala, Long>{
    
}
