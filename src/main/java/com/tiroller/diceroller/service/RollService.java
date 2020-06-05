package com.tiroller.diceroller.service;

import com.tiroller.diceroller.model.Result;
import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Random;

@Service
public class RollService {
    @Autowired
    UnitRepository repository;

    public RollService() {
    }

    public Result roll(String diceSides, String id, String count, String modifier) {
        Unit unit = repository.findUnitById(id);
        ArrayList<Integer> rolls = rollDice(Integer.parseInt(diceSides), Integer.parseInt(count));
//        return new Result(Integer.parseInt(diceSides), unit.getCombat(), Integer.parseInt(count), Integer.parseInt(modifier));
        return new Result(Integer.parseInt(diceSides), unit.getCombat(), Integer.parseInt(count), rolls, Integer.parseInt(modifier));
    }

    public Result rollForNonDBUnit(String diceSides, String combat, String count) {
        return new Result(Integer.parseInt(diceSides), Integer.parseInt(combat), Integer.parseInt(count));
    }

    public ArrayList<Integer> rollDice(int diceSides, int count) {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(diceSides) + 1;
            rolls.add(new Integer(randomInt));
        }
        return rolls;
    }


}
