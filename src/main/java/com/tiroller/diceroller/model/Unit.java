package com.tiroller.diceroller.model;

import javax.persistence.*;

@Entity
@Table(name = "units")
public class Unit {
    @Id
    private String id;
    private String name;
    private int combat;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "unit_type_id")
    private UnitType type;

    public Unit() {};
    public Unit(String id, String name, int combat, UnitType type) {
        this.id = id;
        this.name = name;
        this.combat = combat;
        this.type = type;
    }
    public Unit(String id, String name, int combat) {
        this.id = id;
        this.name = name;
        this.combat = combat;
        this.type = new UnitType("Test");
    }

    @Override
    public String toString() {
        return "Unit{" + "name: " + name + ", combat: " + combat + "}";
    }

    public int getCombat() {
        return combat;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
