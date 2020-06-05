package com.tiroller.diceroller.controller;

import com.tiroller.diceroller.model.Result;
import com.tiroller.diceroller.service.RollService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
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

    @GetMapping("/roll/dread")
    public Result dreadRoll(@RequestParam(value = "id", defaultValue = "dread") String id, @RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "modifier", defaultValue = "0") String modifier) {
        return service.roll(diceSides, id, count, modifier);
    }

    @GetMapping("/roll/warsun")
    public Result warsunRoll(@RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "modifier", defaultValue = "0") String modifier) {
        return service.roll(diceSides, "warsun", count, modifier);
    }

    @GetMapping("/roll/flagship")
    public Result flagshipRoll(@RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "combat", defaultValue = "9") String combat) {
        return service.rollForFlagship(diceSides, combat, count);
    }

    @GetMapping("/roll/spacecannon")
    public Result spaceCannonRoll(@RequestParam(value = "diceSides", defaultValue = "10") String diceSides, @RequestParam(value = "count", defaultValue = "1") String count, @RequestParam(value = "combat", defaultValue = "5") String combat) {
        return service.rollForSpaceCannon(diceSides, combat, count);
    }


}
