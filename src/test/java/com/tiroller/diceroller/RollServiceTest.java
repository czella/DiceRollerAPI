package com.tiroller.diceroller;

import com.tiroller.diceroller.model.Result;
import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.repository.UnitRepository;
import com.tiroller.diceroller.service.RollService;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class RollServiceTest {

    @MockBean
    private UnitRepository unitRepository;

    @Autowired
    private RollService rollService;

    private Unit testFighter = new Unit("fighter", "Fighter", 9);

    @Test
    public void testDiceSides() {
        given(unitRepository.findUnitById("fighter")).willReturn(testFighter);
        Result result = rollService.roll("10", "fighter", "3", "0");
        assertEquals(result.getDiceSides(), 10);
    }

    @Test
    public void testDiceSidesForNonDBUnit() {
        Result result = rollService.rollForNonDBUnit("10", "9", "3");
        assertEquals(result.getDiceSides(), 10);
    }

    @Test
    public void testRollCount() {
        Random randomGenerator = new Random();
        int count = randomGenerator.nextInt(6) + 1;
        given(unitRepository.findUnitById("fighter")).willReturn(testFighter);
        Result result = rollService.roll("10", "fighter", Integer.toString(count), "0");
        assertEquals(result.getRolls().size(), count);
    }

    @Test
    public void testRollCountForNonDBUnits() {
        Random randomGenerator = new Random();
        int count = randomGenerator.nextInt(6) + 1;
        Result result = rollService.rollForNonDBUnit("10", "9", Integer.toString(count));
        assertEquals(result.getRolls().size(), count);
    }

    @Test
    public void testRollValues() {
        int diceSides = 10;
        Random randomGenerator = new Random();
        int count = randomGenerator.nextInt(6) + 1;
        ArrayList<Integer> rolls = rollService.rollDice(diceSides, count);
        rolls.forEach(roll -> assertTrue(roll >= 1 && roll <= diceSides));
    }

}
