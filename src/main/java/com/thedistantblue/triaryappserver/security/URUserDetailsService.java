package com.thedistantblue.triaryappserver.security;

import com.thedistantblue.triaryappserver.database.UserRepositoryJPA;
import com.thedistantblue.triaryappserver.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class URUserDetailsService implements UserDetailsService {

    private UserRepositoryJPA userRepositoryJPA;

    @Autowired
    URUserDetailsService(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }

    public UserDetails loadUserByUsername(String username)
        throws UsernameNotFoundException {

        User user = userRepositoryJPA.findUserByUsername(username);
        if (user != null) {
            log.warn(user.getAuthorities().toString());
            return user;
        }

        throw new UsernameNotFoundException("User " + username + " not found");
    }
}
