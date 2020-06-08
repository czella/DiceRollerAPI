package com.tiroller.diceroller.repository;

import com.tiroller.diceroller.model.UnitType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UnitTypeRepository extends CrudRepository<UnitType, Long> {
    List<UnitType> findAll();
}
