package com.thedistantblue.triaryappserver.database;

import com.thedistantblue.triaryappserver.entity.Running;
import org.springframework.data.repository.CrudRepository;

public interface RunningRepositoryJPA extends CrudRepository<Running, Long> {
}
