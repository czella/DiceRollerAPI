package com.tiroller.diceroller;

import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.repository.UnitTypeRepository;
import com.tiroller.diceroller.seeder.DataSeeder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.tiroller.diceroller.repository.UnitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DicerollerApplication implements CommandLineRunner {
    private static final Logger log = LoggerFactory.getLogger(DicerollerApplication.class);

    @Autowired
    private UnitRepository unitRepository;

    @Autowired
    private UnitTypeRepository unitTypeRepository;

    public static void main(String[] args) {
        SpringApplication.run(DicerollerApplication.class, args);
    }

    @Override
    public void run(String... args) {
        DataSeeder seeder = new DataSeeder(unitRepository, unitTypeRepository);
        log.info("StartApplication...");
        seeder.seed();
    }
}
