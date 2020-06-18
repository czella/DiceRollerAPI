package com.tiroller.diceroller.model;

public class UnitRoll {
    private String name;
    private int combat;
    private int count;
    private int modifier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCombat() {
        return combat;
    }

    public void setCombat(int combat) {
        this.combat = combat;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return "UnitRoll{" +
                "name='" + name + '\'' +
                ", combat='" + combat + '\'' +
                ", count='" + count + '\'' +
                ", modifier='" + modifier + '\'' +
                '}';
    }
}
