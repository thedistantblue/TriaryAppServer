package com.thedistantblue.triaryappserver.database;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JpaTrainingRepositoryTests {
    @Autowired TrainingRepositoryJPA trainingRepositoryJPA;
    @Autowired DataSource dataSource;
    @Autowired EntityManager entityManager;

    @Test
    public void someTest() {
        assertThat(trainingRepositoryJPA).isNotNull();
        assertThat(dataSource).isNotNull();
        assertThat(entityManager).isNotNull();
    }
}
