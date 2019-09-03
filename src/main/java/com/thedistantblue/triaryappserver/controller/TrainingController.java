package com.thedistantblue.triaryappserver.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.thedistantblue.triaryappserver.database.ExerciseRepositoryJPA;
import com.thedistantblue.triaryappserver.database.SetRepositoryJPA;
import com.thedistantblue.triaryappserver.database.TrainingRepositoryJPA;
import com.thedistantblue.triaryappserver.entity.Training;
import com.thedistantblue.triaryappserver.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/training", produces = "application/json")
//@SessionAttributes("user")
public class TrainingController {
    private TrainingRepositoryJPA trainingRepositoryJPA;
    private ExerciseRepositoryJPA exerciseRepositoryJPA;
    private SetRepositoryJPA setRepositoryJPA;

    //Надо возвращать не нового юзера, а юзера, заполненного данными из бд
    //@ModelAttribute("user")
    //public User getUser() {
    //    return new User();
    //}

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
    public Iterable<Training> sendTrainings() {
        return trainingRepositoryJPA.findAll();
    }

    /*
    @GetMapping(path = "/all")
    @ResponseStatus(HttpStatus.OK)
    public String sendTrainings1() {
        List<Training> trainingList = new ArrayList<>();
        trainingRepositoryJPA.findAll().forEach(trainingList::add);
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(trainingList);
        } catch (JsonProcessingException exc) {
            exc.printStackTrace();
            return "";
        }
    }
    */


    @PostMapping(path = "/add", consumes = "application/json")
    public void addTrainings(@RequestBody String json, HttpServletResponse response) {
        System.out.println(json);
        ObjectMapper mapper = new ObjectMapper();
        List<Training> trainings;

        try {
            //Чтобы не падал с ошибкой при обнаружении поля со списком упражнений
            //mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
            trainings = Arrays.asList(mapper.readValue(json, Training[].class));
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(trainings));
        } catch (Exception exc) {
            exc.printStackTrace();
            trainings = new ArrayList<>();
        }


        trainings.forEach(n-> {
            if (!trainingRepositoryJPA.existsByUuidId(n.getUuidId())) {
                Training training = trainingRepositoryJPA.save(n);
                log.warn(String.valueOf(training.getTrainingExercises().size()));
                //for (int i = 0; i < training.getTrainingExercises().size(); i++) {
                //    exerciseRepositoryJPA.save(n.getTrainingExercises().get(i));
                //}
                response.setStatus(HttpServletResponse.SC_CREATED);
                log.warn("DOEST NOT EXIST AND WILL BE CREATED");
            } else {
                log.warn("EXISTS AND WON'T BE CREATED");
                response.setStatus(HttpServletResponse.SC_CONFLICT);
            }
        });

        //trainingRepositoryJPA.saveAll(trainings);
    }

    @PatchMapping(path = "/update/{uuid_id}")
    @ResponseStatus(HttpStatus.CREATED)
    public String patchTrainingByUuidId(@PathVariable("uuid_id") String uuid_id, @RequestBody String str) {
        System.out.println(str);
        return "patching";
    }

    @DeleteMapping(path = "/delete/all")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTrainings() {
        trainingRepositoryJPA.deleteAll();
    }

    @DeleteMapping(path = "delete/{uuid_id}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteTrainingByUuidId(@PathVariable("uuid_id") String uuid_id) {
        trainingRepositoryJPA.deleteById(uuid_id);
    }
}
