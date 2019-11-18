package com.thedistantblue.triaryappserver.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.*;

@Entity
@Data
@NoArgsConstructor //(access = AccessLevel.PRIVATE, force = true)
//@Table(name = "training")
public class Training implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //@JsonProperty("serverId")
    @JsonIgnore
    private long id;

    @JsonProperty("id")
    @Column(name = "uuid_id")
    private String uuidId;

    private long userId;

    private String trainingName;

     // Пишет, что разные форматы, надо будет переделать - СДЕЛАНО
    private Date trainingDate;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "training_id", referencedColumnName = "uuid_id")
    private List<Exercise> trainingExercises;


    /*
    @JsonGetter("trainingDate")
    private String getFormattedDate(String date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(trainingDate);
    }
    */

    @JsonGetter("trainingDate")
    public long getTrainingDate() {
        return this.trainingDate.getTime();
    }
}
