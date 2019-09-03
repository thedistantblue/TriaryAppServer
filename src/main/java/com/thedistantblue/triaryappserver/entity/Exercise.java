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
//@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Exercise implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @JsonProperty("id")
    @Column(name = "uuid_id")
    private String uuidId;

    @Column(name = "training_id")
    private String trainingId;

    private String exerciseName;

    private String exerciseComments;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "exercise_id", referencedColumnName = "uuid_id")
    private List<Set> exerciseSets;

}
