package com.tiroller.diceroller;

import com.tiroller.diceroller.controller.RollController;
import com.tiroller.diceroller.model.Result;
import com.tiroller.diceroller.repository.UnitRepository;
import com.tiroller.diceroller.service.RollService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(RollController.class)
public class RollControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private RollService rollService;

    @MockBean
    private UnitRepository unitRepository;

    @MockBean
    private RollController rollController;

    private ArrayList<Integer> rolls = new ArrayList<>();

    @BeforeEach
    private void rollDice() {
        rolls.add(5);
    };

    @Test
    public void testInfantryRoll() throws Exception {
        Result result = new Result("Infantry", 10, 8, 1, rolls, 0);
        given(rollController.infantryRoll("infantry", "10", "1", "0")).willReturn(result);
        mvc.perform(get("/roll/infantry")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("unitName", is(result.getUnitName())))
                .andExpect(jsonPath("diceSides", is(result.getDiceSides())))
                .andExpect(jsonPath("combat", is(result.getCombat())))
                .andExpect(jsonPath("count", is(result.getCount())))
                .andExpect(jsonPath("rolls", is(result.getRolls())))
                .andExpect(jsonPath("modifier", is(result.getModifier())));
    }

    @Test
    public void testFighterRoll() throws Exception {
        Result result = new Result("Fighter", 10, 9, 1, rolls, 0);
        given(rollController.fighterRoll("fighter", "10", "1", "0")).willReturn(result);
        mvc.perform(get("/roll/fighter")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("unitName", is(result.getUnitName())))
                .andExpect(jsonPath("diceSides", is(result.getDiceSides())))
                .andExpect(jsonPath("combat", is(result.getCombat())))
                .andExpect(jsonPath("count", is(result.getCount())))
                .andExpect(jsonPath("rolls", is(result.getRolls())))
                .andExpect(jsonPath("modifier", is(result.getModifier())));
    }

    @Test
    public void testCarrierRoll() throws Exception {
        Result result = new Result("Carrier", 10, 9, 1, rolls, 0);
        given(rollController.carrierRoll( "10", "1", "0")).willReturn(result);
        mvc.perform(get("/roll/carrier")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("unitName", is(result.getUnitName())))
                .andExpect(jsonPath("diceSides", is(result.getDiceSides())))
                .andExpect(jsonPath("combat", is(result.getCombat())))
                .andExpect(jsonPath("count", is(result.getCount())))
                .andExpect(jsonPath("rolls", is(result.getRolls())))
                .andExpect(jsonPath("modifier", is(result.getModifier())));
    }

    @Test
    public void testDestroyerRoll() throws Exception {
        Result result = new Result("Destroyer", 10, 9, 1, rolls, 0);
        given(rollController.destroyerRoll("destroyer", "10", "1", "0")).willReturn(result);
        mvc.perform(get("/roll/destroyer")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("unitName", is(result.getUnitName())))
                .andExpect(jsonPath("diceSides", is(result.getDiceSides())))
                .andExpect(jsonPath("combat", is(result.getCombat())))
                .andExpect(jsonPath("count", is(result.getCount())))
                .andExpect(jsonPath("rolls", is(result.getRolls())))
                .andExpect(jsonPath("modifier", is(result.getModifier())));
    }

    @Test
    public void testCruiserRoll() throws Exception {
        Result result = new Result("Cruiser", 10, 7, 1, rolls, 0);
        given(rollController.cruiserRoll("cruiser", "10", "1", "0")).willReturn(result);
        mvc.perform(get("/roll/cruiser")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("unitName", is(result.getUnitName())))
                .andExpect(jsonPath("diceSides", is(result.getDiceSides())))
                .andExpect(jsonPath("combat", is(result.getCombat())))
                .andExpect(jsonPath("count", is(result.getCount())))
                .andExpect(jsonPath("rolls", is(result.getRolls())))
                .andExpect(jsonPath("modifier", is(result.getModifier())));
    }

    @Test
    public void testDreadRoll() throws Exception {
        Result result = new Result("Dreadnought", 10, 5, 1, rolls, 0);
        given(rollController.dreadRoll("dread", "10", "1", "0")).willReturn(result);
        mvc.perform(get("/roll/dread")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("unitName", is(result.getUnitName())))
                .andExpect(jsonPath("diceSides", is(result.getDiceSides())))
                .andExpect(jsonPath("combat", is(result.getCombat())))
                .andExpect(jsonPath("count", is(result.getCount())))
                .andExpect(jsonPath("rolls", is(result.getRolls())))
                .andExpect(jsonPath("modifier", is(result.getModifier())));
    }

    @Test
    public void testWarsunRoll() throws Exception {
        Result result = new Result("Warsun", 10, 7, 1, rolls, 0);
        given(rollController.warsunRoll( "10", "1", "0")).willReturn(result);
        mvc.perform(get("/roll/warsun")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("unitName", is(result.getUnitName())))
                .andExpect(jsonPath("diceSides", is(result.getDiceSides())))
                .andExpect(jsonPath("combat", is(result.getCombat())))
                .andExpect(jsonPath("count", is(result.getCount())))
                .andExpect(jsonPath("rolls", is(result.getRolls())))
                .andExpect(jsonPath("modifier", is(result.getModifier())));
    }

    @Test
    public void testFlagshipRoll() throws Exception {
        Result result = new Result("Flagship", 10, 9, 1, rolls, 0);
        given(rollController.flagshipRoll( "10", "1", "9")).willReturn(result);
        mvc.perform(get("/roll/flagship")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("unitName", is(result.getUnitName())))
                .andExpect(jsonPath("diceSides", is(result.getDiceSides())))
                .andExpect(jsonPath("combat", is(result.getCombat())))
                .andExpect(jsonPath("count", is(result.getCount())))
                .andExpect(jsonPath("rolls", is(result.getRolls())))
                .andExpect(jsonPath("modifier", is(result.getModifier())));
    }

    @Test
    public void testSpaceCannonRoll() throws Exception {
        Result result = new Result("Space Cannon",10, 5, 1, rolls, 0);
        given(rollController.spaceCannonRoll( "10", "1", "5")).willReturn(result);
        mvc.perform(get("/roll/spacecannon")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("unitName", is(result.getUnitName())))
                .andExpect(jsonPath("diceSides", is(result.getDiceSides())))
                .andExpect(jsonPath("combat", is(result.getCombat())))
                .andExpect(jsonPath("count", is(result.getCount())))
                .andExpect(jsonPath("rolls", is(result.getRolls())))
                .andExpect(jsonPath("modifier", is(result.getModifier())));
    }

}
