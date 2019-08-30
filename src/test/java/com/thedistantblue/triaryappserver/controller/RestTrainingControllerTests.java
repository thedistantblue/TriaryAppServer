package com.thedistantblue.triaryappserver.controller;

import com.thedistantblue.triaryappserver.database.TrainingRepositoryJPA;
import com.thedistantblue.triaryappserver.entity.Training;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class RestTrainingControllerTests {
    @Autowired
    TrainingController trainingController;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    TrainingRepositoryJPA trainingRepositoryJPA;

    @Test
    public void contextLoads() {
        assertThat(trainingController).isNotNull();
    }

    @Test
    public void testGetMappingController() throws Exception {
        Iterable<Training> trainingIterable = trainingRepositoryJPA.findAll();
        List<Training> trainingList = new ArrayList<>();
        trainingIterable.forEach(trainingList::add);

        StringBuilder object = new StringBuilder();
        for (int i = 0; i < trainingList.size(); i++) {
            if (i == trainingList.size()-1) {
                object.append("{}");
            } else {
                object.append("{},");
            }
        }

        mockMvc
                .perform(MockMvcRequestBuilders.get("/training/all"))
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
                .andExpect(MockMvcResultMatchers.content().json("[" + object + "]"));
    }

}
