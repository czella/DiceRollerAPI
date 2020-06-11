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

    public Unit createUnit(String id, String name, int combat, UnitType unitType) {
        Unit unit = new Unit(id, name, combat, unitType);
        unitRepository.save(unit);
        return unit;
    };

    public void seed() {

        UnitType infantryType = new UnitType("Infantry");
        unitTypeRepository.save(infantryType);
        infantryType.getUnits().add(createUnit("infantry", "Infantry", 8, infantryType));
        infantryType.getUnits().add(createUnit("infantry2", "Infantry II", 7, infantryType));
        infantryType.getUnits().add(createUnit("solinfantry", "Sol Infantry", 7, infantryType));
        infantryType.getUnits().add(createUnit("solinfantry2", "Sol Infantry II", 6, infantryType));
        unitTypeRepository.save(infantryType);

        UnitType fighterType = new UnitType("Fighter");
        unitTypeRepository.save(fighterType);
        fighterType.getUnits().add(createUnit("fighter", "Fighter", 9, fighterType));
        fighterType.getUnits().add(createUnit("fighter2", "Fighter II", 8, fighterType));
        fighterType.getUnits().add(createUnit("naalufighter", "Naalu Fighter", 8, fighterType));
        fighterType.getUnits().add(createUnit("naalufighter2", "Naalu Fighter II", 7, fighterType));
        unitTypeRepository.save(fighterType);

        UnitType destroyerType = new UnitType("Destroyer");
        unitTypeRepository.save(destroyerType);
        destroyerType.getUnits().add(createUnit("destroyer", "Destroyer", 9, destroyerType));
        destroyerType.getUnits().add(createUnit("destroyer2", "Destroyer II", 8, destroyerType));
        unitTypeRepository.save(destroyerType);

        UnitType carrierType = new UnitType("Carrier");
        unitTypeRepository.save(carrierType);
        carrierType.getUnits().add(createUnit("carrier", "Carrier", 9, carrierType));
        unitTypeRepository.save(carrierType);

        UnitType cruiserType = new UnitType("Cruiser");
        unitTypeRepository.save(cruiserType);
        cruiserType.getUnits().add(createUnit("cruiser", "Cruiser", 7, cruiserType));
        cruiserType.getUnits().add(createUnit("cruiser2", "Cruiser II", 6, cruiserType));
        unitTypeRepository.save(cruiserType);

        UnitType dreadType = new UnitType("Dreadnought");
        unitTypeRepository.save(dreadType);
        dreadType.getUnits().add(createUnit("dread", "Dreadnought", 5, dreadType));
        dreadType.getUnits().add(createUnit("l1z1xdread2", "L1z1x Dreadnought II", 4, dreadType));
        unitTypeRepository.save(dreadType);

        UnitType warsunType = new UnitType("Warsun");
        unitTypeRepository.save(warsunType);
        warsunType.getUnits().add(createUnit("warsun", "Warsun", 3, warsunType));
        unitTypeRepository.save(warsunType);

        UnitType flagshipType = new UnitType("Flagship");
        unitTypeRepository.save(flagshipType);

        UnitType spaceCannonType = new UnitType("Space Cannon");
        unitTypeRepository.save(spaceCannonType);

    }
}
