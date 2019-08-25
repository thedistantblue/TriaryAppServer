package com.thedistantblue.triaryappserver.database;

import com.thedistantblue.triaryappserver.entity.Exercise;
import org.springframework.data.repository.CrudRepository;

public interface ExerciseRepositoryJPA extends CrudRepository<Exercise, Long> {
}
