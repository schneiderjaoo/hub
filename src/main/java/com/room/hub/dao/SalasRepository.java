package com.room.hub.dao;

import com.room.hub.bean.Salas;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalasRepository extends CrudRepository<Salas, Long> {
}
