package com.tiroller.diceroller.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Unit {
    @Id
    private String id;
    private String name;
    private int combat;

    public Unit() {};
    public Unit(String id, String name, int combat) {
        this.id = id;
        this.name = name;
        this.combat = combat;
    }

    @Override
    public String toString() {
        return "Unit{" + "name: " + name + ", combat: " + combat + "}";
    }

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
