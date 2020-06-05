package com.tiroller.diceroller.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Result {
    private final int diceSides;
    private final int combat;
    private final int count;
    private final ArrayList<Integer> rolls;
    private final int hits;
    private final int modifier;

    public Result(int diceSides, int combat, int count, int modifier) {
        this.diceSides = diceSides;
        this.combat = combat;
        this.count = count;
        this.modifier = modifier;
        ArrayList<Integer> diceRolls = rollDice(diceSides, count);
        this.rolls = diceRolls;
        this.hits = calculateHits(diceSides, diceRolls, combat, modifier);
    }

    public Result(int diceSides, int combat, int count, ArrayList<Integer> rolls, int modifier) {
        this.diceSides = diceSides;
        this.combat = combat;
        this.count = count;
        this.modifier = modifier;
        this.rolls = rolls;
        this.hits = calculateHits(diceSides, rolls, combat, modifier);
    }

    public Result(int diceSides, int combat, int count) {
        this.diceSides = diceSides;
        this.combat = combat;
        this.count = count;
        this.modifier = 0;
        ArrayList<Integer> diceRolls = rollDice(diceSides, count);
        this.rolls = diceRolls;
        this.hits = calculateHits(diceSides, diceRolls, combat, modifier);
    }

    private ArrayList<Integer> rollDice(int diceSides, int count) {
        ArrayList<Integer> rolls = new ArrayList<Integer>();
        for (int i = 0; i < count; i++) {
            Random randomGenerator = new Random();
            int randomInt = randomGenerator.nextInt(diceSides) + 1;
            rolls.add(new Integer(randomInt));
        }
        return rolls;
    }

    private int calculateHits(int diceSides, ArrayList<Integer> rolls, int combat, int modifier) {
        int hits = 0;
        for (Integer roll : rolls) {
            if (roll + modifier >= combat || roll.intValue() == diceSides) {
                hits++;
            }
        }
        return hits;
    }

    public int getDiceSides() {
        return diceSides;
    }

    public int getCombat() {
        return combat;
    }

    public int getCount() {
        return count;
    }

    public ArrayList<Integer> getRolls() {
        return rolls;
    }

    public int getHits() {
        return hits;
    }

    public int getModifier() {
        return modifier;
    }
}
