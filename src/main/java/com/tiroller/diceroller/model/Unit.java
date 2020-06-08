package com.tiroller.diceroller.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

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
