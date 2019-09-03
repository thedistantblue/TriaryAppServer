package com.thedistantblue.triaryappserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Data
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
@Table(name = "Settable")
public class Set implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonProperty("id")
    private String uuidId;

    @Column(name = "exercise_id")
    private String exerciseId;

    private int setNumber;

    private int setRepetitions;

    private double setWeight;

}

