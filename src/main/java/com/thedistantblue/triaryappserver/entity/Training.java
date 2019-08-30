package com.thedistantblue.triaryappserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.*;

@Entity
@Data
@NoArgsConstructor //(access = AccessLevel.PRIVATE, force = true)
@Table(name = "training_test")
public class Training implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonProperty("serverId")
    @JsonIgnore
    private long id;

    @JsonProperty("id")
    private String uuidId;

    private long userId;

    private String trainingName;

    @JsonIgnore // Пишет, что разные форматы, надо будет переделать
    private Date trainingDate;

    //@OneToMany(targetEntity = Exercise.class)
    //private List<Exercise> trainingExercises;

}
