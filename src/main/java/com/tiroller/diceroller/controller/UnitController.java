package com.tiroller.diceroller.controller;

import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.model.UnitType;
import com.tiroller.diceroller.repository.UnitRepository;
import com.tiroller.diceroller.repository.UnitTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UnitController {

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private UnitTypeRepository unitTypeRepository;

    @GetMapping("/units")
    public List<Unit> getUnits() {
        return unitRepository.findAll();
    }

    @GetMapping("/unittypes")
    public List<UnitType> getUnitTypes() {
        return unitTypeRepository.findAll();
    }

    @GetMapping("/unitsbytype")
    public List<Unit> getUnitsByType(@RequestParam(value = "type", defaultValue = "Infantry") String type) {
        UnitType unitType = unitTypeRepository.findUnitTypeByName(type);
        return unitRepository.findUnitsByType(unitType);
    }

}
