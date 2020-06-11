package com.tiroller.diceroller.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "unit_types")
public class UnitType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JoinColumn(name = "unit_type_id", nullable = false, foreignKey = @ForeignKey(name="unit_type_id"))
    private Long id;
    private String name;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<Unit> units = new ArrayList<>();

    public UnitType() {
    }

    public UnitType(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Unit> getUnits() {
        return units;
    }
}
