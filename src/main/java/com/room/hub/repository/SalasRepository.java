package com.room.hub.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.room.hub.model.Salas;

@Repository
public interface SalasRepository extends CrudRepository<Salas, Long> {
}
