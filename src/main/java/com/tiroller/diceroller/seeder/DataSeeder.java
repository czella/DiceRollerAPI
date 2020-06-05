package com.tiroller.diceroller.seeder;

import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.repository.UnitRepository;

public class DataSeeder {
    private UnitRepository repository;

    public DataSeeder(UnitRepository repository) {
        this.repository = repository;
    }

    public void seed() {
        repository.save(new Unit("fighter", "Fighter", 9));
        repository.save(new Unit("fighter2", "Fighter II", 8));
        repository.save(new Unit("naalufighter", "Naalu Fighter", 8));
        repository.save(new Unit("naalufighter2", "Naalu Fighter II", 7));
        repository.save(new Unit("infantry", "Infantry", 8));
        repository.save(new Unit("infantry2", "Infantry II", 7));
        repository.save(new Unit("solinfantry", "Sol Infantry", 7));
        repository.save(new Unit("solinfantry2", "Infantry II", 6));
        repository.save(new Unit("carrier", "Carrier", 9));
        repository.save(new Unit("destroyer", "Destroyer", 9));
        repository.save(new Unit("destroyer2", "Destroyer II", 8));
        repository.save(new Unit("cruiser", "Cruiser", 7));
        repository.save(new Unit("cruiser2", "Cruiser II", 6));
        repository.save(new Unit("dread", "Dreadnought", 5));
        repository.save(new Unit("l1z1xdread2", "L1z1x Dreadnought II", 4));
        repository.save(new Unit("warsun", "Warsun", 3));
    }
}
