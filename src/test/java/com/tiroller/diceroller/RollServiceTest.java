package com.tiroller.diceroller;

import com.tiroller.diceroller.model.Result;
import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.repository.UnitRepository;
import com.tiroller.diceroller.service.RollService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

@SpringBootTest
public class RollServiceTest {

    @MockBean
    private UnitRepository unitRepository;

    @Autowired
    private RollService rollService;

    @Test
    public void testDiceSides() {
        Unit fighter = new Unit("fighter", "Fighter", 9);
        given(unitRepository.findUnitById("fighter")).willReturn(fighter);
        Result result = rollService.roll("10", "fighter", "3", "0");
        assertEquals(result.getDiceSides(), 10);

    }
}
