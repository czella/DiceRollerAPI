package com.tiroller.diceroller.controller;

import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class UnitController {

    @Autowired
    private UnitRepository unitRepository;

    @GetMapping("/units")
    public List<Unit> getUnits() {
        return unitRepository.findAll();
    }

    @GetMapping("/unittypes")
    public List<Unit> getUnitTypes() {
        return unitRepository.findAll();
    }

}
