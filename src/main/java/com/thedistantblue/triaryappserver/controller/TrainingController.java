package com.thedistantblue.triaryappserver.controller;

import com.thedistantblue.triaryappserver.database.ExerciseRepositoryJPA;
import com.thedistantblue.triaryappserver.database.SetRepositoryJPA;
import com.thedistantblue.triaryappserver.database.TrainingRepositoryJPA;
import com.thedistantblue.triaryappserver.entity.Training;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public Iterable<Training> sendTrainingList() {
        return trainingRepositoryJPA.findAll();
    }
}
