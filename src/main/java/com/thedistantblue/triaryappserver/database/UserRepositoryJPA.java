package com.thedistantblue.triaryappserver.database;

import com.thedistantblue.triaryappserver.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryJPA extends CrudRepository<User, Long> {
    User findUserByUsername(String username);
}
