package com.tiroller.diceroller.model;

import java.util.ArrayList;

public class Result {
    private final String unitName;
    private final int diceSides;
    private final int combat;
    private final int count;
    private final ArrayList<Integer> rolls;
    private final int hits;
    private final int modifier;

    public Result(String unitName, int diceSides, int combat, int count, ArrayList<Integer> rolls, int modifier) {
        this.unitName = unitName;
        this.diceSides = diceSides;
        this.combat = combat;
        this.count = count;
        this.modifier = modifier;
        this.rolls = rolls;
        this.hits = calculateHits(diceSides, rolls, combat, modifier);
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

    public String getUnitName() {
        return unitName;
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
