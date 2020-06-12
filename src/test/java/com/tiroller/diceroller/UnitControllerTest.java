package com.tiroller.diceroller;

import com.tiroller.diceroller.controller.RollController;
import com.tiroller.diceroller.controller.UnitController;
import com.tiroller.diceroller.model.Result;
import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.model.UnitType;
import com.tiroller.diceroller.repository.UnitRepository;
import com.tiroller.diceroller.repository.UnitTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.http.MediaType.APPLICATION_JSON;

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
    private Unit test1 = new Unit("test1", "Test1", 9, type1);
    private Unit test2 = new Unit("test2", "Test2", 9, type2);

    @Test
    public void testGetUnits() throws Exception {

        List<Unit> result = new ArrayList<>();
        result.add(test1);
        result.add(test2);
        given(unitController.getUnits()).willReturn(result);
        mvc.perform(get("/units")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].id", is(test1.getId())))
                .andExpect(jsonPath("$[0].name", is(test1.getName())))
                .andExpect(jsonPath("$[0].combat", is(test1.getCombat())))
                .andExpect(jsonPath("$[1].id", is(test2.getId())))
                .andExpect(jsonPath("$[1].name", is(test2.getName())))
                .andExpect(jsonPath("$[1].combat", is(test2.getCombat())));
    }

    @Test
    public void testGetUnitTypes() throws Exception {

        List<UnitType> result = new ArrayList<>();
        result.add(type1);
        result.add(type2);
        given(unitController.getUnitTypes()).willReturn(result);
        mvc.perform(get("/unittypes")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)))
                .andExpect(jsonPath("$[0].name", is(type1.getName())))
                .andExpect(jsonPath("$[1].name", is(type2.getName())));
    }

    @Test
    public void testGetUnitsByType() throws Exception {
        List<Unit> result = new ArrayList<>();
        result.add(test1);
        given(unitController.getUnitsByType("test")).willReturn(result);
        mvc.perform(get("/unitsbytype?type=test")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].id", is(test1.getId())))
                .andExpect(jsonPath("$[0].name", is(test1.getName())))
                .andExpect(jsonPath("$[0].combat", is(test1.getCombat())));
    }
}
