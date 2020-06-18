package com.tiroller.diceroller.controller;

import com.tiroller.diceroller.model.Result;
import com.tiroller.diceroller.model.UnitRoll;
import com.tiroller.diceroller.service.RollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class RollController {

    @Autowired
    private RollService service;

    @GetMapping("/roll")
    public String greeting() {
        return "Welcome to DiceRoller!";
    }

    @GetMapping("/roll/infantry")
    public Result infantryRoll(@RequestParam(value = "id", defaultValue = "infantry") String id, @RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "modifier", defaultValue = "0") String modifier) {
        return service.roll(diceSides, id, count, modifier);
    }

    @GetMapping("/roll/fighter")
    public Result fighterRoll(@RequestParam(value = "id", defaultValue = "fighter") String id, @RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "modifier", defaultValue = "0") String modifier) {
        return service.roll(diceSides, id, count, modifier);
    }

    @GetMapping("/roll/destroyer")
    public Result destroyerRoll(@RequestParam(value = "id", defaultValue = "destroyer") String id, @RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "modifier", defaultValue = "0") String modifier) {
        return service.roll(diceSides, id, count, modifier);
    }

    @GetMapping("/roll/carrier")
    public Result carrierRoll(@RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "modifier", defaultValue = "0") String modifier) {
        return service.roll(diceSides, "carrier", count, modifier);
    }

    @GetMapping("/roll/cruiser")
    public Result cruiserRoll(@RequestParam(value = "id", defaultValue = "cruiser") String id, @RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "modifier", defaultValue = "0") String modifier) {
        return service.roll(diceSides, id, count, modifier);
    }

    @GetMapping("/roll/dreadnought")
    public Result dreadRoll(@RequestParam(value = "id", defaultValue = "dread") String id, @RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "modifier", defaultValue = "0") String modifier) {
        return service.roll(diceSides, id, count, modifier);
    }

    @GetMapping("/roll/warsun")
    public Result warsunRoll(@RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "modifier", defaultValue = "0") String modifier) {
        return service.roll(diceSides, "warsun", count, modifier);
    }

    @GetMapping("/roll/flagship")
    public Result flagshipRoll(@RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "combat", defaultValue = "9") String combat, @RequestParam(value = "modifier", defaultValue = "0") String modifier) {
        return service.rollForNonDBUnit("Flagship", diceSides, combat, count, modifier);
    }

    @GetMapping("/roll/spacecannon")
    public Result spaceCannonRoll(@RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "combat", defaultValue = "5") String combat, @RequestParam(value = "modifier", defaultValue = "0") String modifier) {
        return service.rollForNonDBUnit("Space cannon", diceSides, combat, count, modifier);
    }

    @PostMapping(path = "/roll/combined", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<Result> combinedRoll(@RequestBody List<UnitRoll> rolls) {
        return service.combinedRoll(rolls);
    }


}
