package com.room.hub.dao;

import com.room.hub.bean.Salas;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SalasRepository extends CrudRepository<Salas, Long> {
    //Gambi braba
    //@Query("SELECT MAX(s.id) FROM Salas s")
    //Long gambi();
}
