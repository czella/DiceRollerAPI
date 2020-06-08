package com.tiroller.diceroller.seeder;

import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.model.UnitType;
import com.tiroller.diceroller.repository.UnitRepository;
import com.tiroller.diceroller.repository.UnitTypeRepository;

public class DataSeeder {
    private UnitRepository unitRepository;
    private UnitTypeRepository unitTypeRepository;

    public DataSeeder(UnitRepository unitRepository, UnitTypeRepository unitTypeRepository) {
        this.unitRepository = unitRepository;
        this.unitTypeRepository = unitTypeRepository;
    }

    public void seed() {
        unitRepository.save(new Unit("fighter", "Fighter", 9));
        unitRepository.save(new Unit("fighter2", "Fighter II", 8));
        unitRepository.save(new Unit("naalufighter", "Naalu Fighter", 8));
        unitRepository.save(new Unit("naalufighter2", "Naalu Fighter II", 7));
        unitRepository.save(new Unit("infantry", "Infantry", 8));
        unitRepository.save(new Unit("infantry2", "Infantry II", 7));
        unitRepository.save(new Unit("solinfantry", "Sol Infantry", 7));
        unitRepository.save(new Unit("solinfantry2", "Infantry II", 6));
        unitRepository.save(new Unit("carrier", "Carrier", 9));
        unitRepository.save(new Unit("destroyer", "Destroyer", 9));
        unitRepository.save(new Unit("destroyer2", "Destroyer II", 8));
        unitRepository.save(new Unit("cruiser", "Cruiser", 7));
        unitRepository.save(new Unit("cruiser2", "Cruiser II", 6));
        unitRepository.save(new Unit("dread", "Dreadnought", 5));
        unitRepository.save(new Unit("l1z1xdread2", "L1z1x Dreadnought II", 4));
        unitRepository.save(new Unit("warsun", "Warsun", 3));

        unitTypeRepository.save(new UnitType("Fighter"));
        unitTypeRepository.save(new UnitType("Destroyer"));
        unitTypeRepository.save(new UnitType("Carrier"));
        unitTypeRepository.save(new UnitType("Cruiser"));
        unitTypeRepository.save(new UnitType("Dreadnought"));
        unitTypeRepository.save(new UnitType("Warsun"));
        unitTypeRepository.save(new UnitType("Flagship"));
        unitTypeRepository.save(new UnitType("Space Cannon"));
    }
}
