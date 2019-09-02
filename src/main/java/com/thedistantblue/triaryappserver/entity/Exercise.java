package com.thedistantblue.triaryappserver.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;


@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonProperty("id")
    private String uuidId;

    private String trainingId;

    private String exerciseName;

    private String exerciseComments;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Set> exerciseSets;

}
