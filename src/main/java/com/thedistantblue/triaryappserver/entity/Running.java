package com.thedistantblue.triaryappserver.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class Running implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotBlank
    private UUID uuid_id;

    @NotBlank
    private long userId;

    @NotBlank
    private String runningName;

    private Date date;

    @NotBlank
    private double distance;

    @NotBlank
    private double speed;

    @NotBlank
    private double time;

    @NotBlank
    private double calories;

    @NotBlank
    private String comments;

}

