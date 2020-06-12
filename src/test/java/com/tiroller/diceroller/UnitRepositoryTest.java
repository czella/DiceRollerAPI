package com.tiroller.diceroller;

import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.model.UnitType;
import com.tiroller.diceroller.repository.UnitRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.beans.HasPropertyWithValue.hasProperty;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UnitRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UnitRepository unitRepository;

    @Test
    public void testFindUnitById() {
        UnitType testType = new UnitType("Test type");
        entityManager.persist(testType);
        Unit test = new Unit("test", "Test", 9, testType);
        entityManager.persist(test);
        testType.getUnits().add(test);
        entityManager.flush();

        Unit found = unitRepository.findUnitById(test.getId());

        assertThat(found.getId())
                .isEqualTo(test.getId());
    }
    @Test
    public void testFindUnitByType() {
        UnitType testType = new UnitType("Test type");
        entityManager.persist(testType);
        Unit test1 = new Unit("test", "Test", 9, testType);
        Unit test2 = new Unit("test2", "Test2", 9, testType);
        entityManager.persist(test1);
        entityManager.persist(test2);
        testType.getUnits().add(test1);
        testType.getUnits().add(test2);
        entityManager.flush();

        List<Unit> found = unitRepository.findUnitsByType(testType);

        assertThat(found, contains(
                hasProperty("id", is(test1.getId())),
                hasProperty("id", is(test2.getId()))
        ));
    }
}
