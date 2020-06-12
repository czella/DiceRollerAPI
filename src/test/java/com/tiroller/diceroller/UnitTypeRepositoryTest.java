package com.tiroller.diceroller;

import com.tiroller.diceroller.model.UnitType;
import com.tiroller.diceroller.repository.UnitTypeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class UnitTypeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UnitTypeRepository unitTypeRepository;

    @Test
    public void testFindUnitTypeByName() {
        UnitType testType = new UnitType("Test type");
        entityManager.persist(testType);
        entityManager.flush();

        UnitType found = unitTypeRepository.findUnitTypeByName(testType.getName());
        assertThat(found.getId())
                .isEqualTo(testType.getId());
    }
}
