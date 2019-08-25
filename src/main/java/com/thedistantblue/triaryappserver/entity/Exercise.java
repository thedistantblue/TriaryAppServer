package com.thedistantblue.triaryappserver.entity;

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
    private long id;

    @NotBlank
    private UUID uuid_id;

    @NotBlank
    private UUID trainingId;

    @NotBlank
    private String exerciseName;

    @NotBlank
    private String exerciseComments;

    @ManyToOne(targetEntity = Set.class)
    private List<Set> exerciseSets;

}
