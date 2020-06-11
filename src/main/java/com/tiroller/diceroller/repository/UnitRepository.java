package com.tiroller.diceroller.repository;

import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.model.UnitType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitRepository extends CrudRepository<Unit, Long> {
    List<Unit> findAll();
    Unit findUnitById(String id);
    List<Unit> findUnitsByType(UnitType type);
}
