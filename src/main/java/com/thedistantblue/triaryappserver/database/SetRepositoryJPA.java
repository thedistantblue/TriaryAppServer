package com.thedistantblue.triaryappserver.database;

import com.thedistantblue.triaryappserver.entity.Set;
import org.springframework.data.repository.CrudRepository;

public interface SetRepositoryJPA extends CrudRepository<Set, Long> {
}
