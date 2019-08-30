package com.thedistantblue.triaryappserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thedistantblue.triaryappserver.database.ExerciseRepositoryJPA;
import com.thedistantblue.triaryappserver.database.SetRepositoryJPA;
import com.thedistantblue.triaryappserver.database.TrainingRepositoryJPA;
import com.thedistantblue.triaryappserver.entity.Training;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/training", produces = "application/json")
public class TrainingController {
    private TrainingRepositoryJPA trainingRepositoryJPA;
    private ExerciseRepositoryJPA exerciseRepositoryJPA;
    private SetRepositoryJPA setRepositoryJPA;

    @Autowired
    public TrainingController(TrainingRepositoryJPA trainingRepositoryJPA,
                              ExerciseRepositoryJPA exerciseRepositoryJPA,
                              SetRepositoryJPA setRepositoryJPA)
    {
        this.trainingRepositoryJPA = trainingRepositoryJPA;
        this.exerciseRepositoryJPA = exerciseRepositoryJPA;
        this.setRepositoryJPA = setRepositoryJPA;
    }

    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public Iterable<Training> sendTrainingList() {
        return trainingRepositoryJPA.findAll();
    }

    @PostMapping(path = "/add", consumes = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void addTraining(@RequestBody String json, HttpServletResponse response) {
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        List<Training> trainings;

        try {
            //Чтобы не падал с ошибкой при обнаружении поля со списком упражнений
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            trainings = Arrays.asList(mapper.readValue(json, Training[].class));
        } catch (Exception exc) {
            exc.printStackTrace();
            trainings = new ArrayList<>();
        }

        trainings.forEach(n-> {
            if (!trainingRepositoryJPA.existsByUuidId(n.getUuidId())) {
                trainingRepositoryJPA.save(n);
                log.warn("DOEST NOT EXIST AND WILL BE CREATED");
            } else {
                log.warn("EXISTS AND WON'T BE CREATED");
            }
        });
        //trainingRepositoryJPA.saveAll(trainings);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String testPatch(@RequestBody String str) {
        System.out.println(str);
        return "patching";
    }
}
