package com.thedistantblue.triaryappserver.database;

import com.thedistantblue.triaryappserver.entity.Training;
import org.springframework.data.repository.CrudRepository;

public interface TrainingRepositoryJPA extends CrudRepository<Training, Long> {
}
