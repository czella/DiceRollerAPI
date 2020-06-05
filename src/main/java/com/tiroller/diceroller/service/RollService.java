package com.tiroller.diceroller.service;

import com.tiroller.diceroller.model.Result;
import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RollService {
    @Autowired
    UnitRepository repository;

    public RollService() {
    }

    public Result roll(String diceSides, String id, String count, String modifier) {
        Unit unit = repository.findUnitById(id);
        return new Result(Integer.parseInt(diceSides), unit.getCombat(), Integer.parseInt(count), Integer.parseInt(modifier));
    }

    public Result rollForFlagship(String diceSides, String combat, String count) {
        return new Result(Integer.parseInt(diceSides), Integer.parseInt(combat), Integer.parseInt(count));
    }
}
