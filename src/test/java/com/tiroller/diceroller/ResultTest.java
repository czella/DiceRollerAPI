package com.tiroller.diceroller;

import com.tiroller.diceroller.model.Result;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.Random;

import static org.junit.Assert.assertEquals;

@SpringBootTest
public class ResultTest {

    @Test
    public void testHitCalculation() {
        int diceSides = 10;
        int actualHits = 0;
        int combat = 9;
        int count = 4;
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        Random randomGenerator = new Random();
        for (int i = 0; i < count; i++) {
            int roll = randomGenerator.nextInt(diceSides) + 1;
            rolls.add(roll);
            if (roll >= combat || roll == diceSides) {
                actualHits++;
            }
        }
        Result result = new Result(diceSides, combat, count, rolls, 0 );
        assertEquals(result.getHits(), actualHits);
    }
}
