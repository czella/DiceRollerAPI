package com.tiroller.diceroller;

import com.tiroller.diceroller.controller.RollController;
import com.tiroller.diceroller.controller.UnitController;
import com.tiroller.diceroller.model.Result;
import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.model.UnitType;
import com.tiroller.diceroller.repository.UnitRepository;
import com.tiroller.diceroller.repository.UnitTypeRepository;
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
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.hamcrest.core.Is.is;

@RunWith(SpringRunner.class)
@WebMvcTest(UnitController.class)
public class UnitControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private UnitRepository unitRepository;

    @MockBean
    UnitTypeRepository unitTypeRepository;

    @MockBean
    UnitController unitController;

    private UnitType type1 = new UnitType("Test type1");
    private UnitType type2 = new UnitType("Test type2");

    @Test
    public void testGetUnits() throws Exception {

        List<Unit> result = new ArrayList<>();
        result.add(new Unit("test1", "Test1", 9, type1));
        result.add(new Unit("test2", "Test2", 9, type2));
        given(unitController.getUnits()).willReturn(result);
        mvc.perform(get("/units")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());
//                .andExpect(jsonPath("unitName", is(result.getUnitName())))
//                .andExpect(jsonPath("diceSides", is(result.getDiceSides())))
//                .andExpect(jsonPath("combat", is(result.getCombat())))
//                .andExpect(jsonPath("count", is(result.getCount())))
//                .andExpect(jsonPath("rolls", is(result.getRolls())))
//                .andExpect(jsonPath("modifier", is(result.getModifier())));
    }
}
