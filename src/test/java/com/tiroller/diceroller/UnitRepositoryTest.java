package com.tiroller.diceroller;

import com.tiroller.diceroller.model.Unit;
import com.tiroller.diceroller.repository.UnitRepository;
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
public class UnitRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private UnitRepository unitRepository;

    @Test
    public void testFindUnitById() {
        // given
        Unit test = new Unit("test", "Test", 9);
        entityManager.persist(test);
        entityManager.flush();

        // when
        Unit found = unitRepository.findUnitById(test.getId());

        // then
        assertThat(found.getId())
                .isEqualTo(test.getId());
    }
}
