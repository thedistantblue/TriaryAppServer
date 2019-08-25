package com.thedistantblue.triaryappserver.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "training_test")
public class Training implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private String uuidId;

    @NotBlank
    private long userId;

    @NotBlank
    private String trainingName;

    @NotBlank
    private Date trainingDate;

    //@ManyToOne(targetEntity = Exercise.class)
    //private List<Exercise> trainingExercises;

}
