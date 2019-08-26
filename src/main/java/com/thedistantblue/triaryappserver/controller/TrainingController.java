package com.thedistantblue.triaryappserver.controller;

import com.thedistantblue.triaryappserver.database.ExerciseRepositoryJPA;
import com.thedistantblue.triaryappserver.database.SetRepositoryJPA;
import com.thedistantblue.triaryappserver.database.TrainingRepositoryJPA;
import com.thedistantblue.triaryappserver.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public Iterable<Training> sendTrainingList() {
        return trainingRepositoryJPA.findAll();
    }

    @PostMapping(path = "/add", consumes = "application/json")
    public void addTraining(@RequestBody String str) {
        System.out.println(str);
        //trainingRepositoryJPA.save(training);
    }
}
