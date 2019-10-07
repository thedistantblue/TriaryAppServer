package com.thedistantblue.triaryappserver.security;

import com.thedistantblue.triaryappserver.database.UserRepositoryJPA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
@RequestMapping(path = "/login")
public class LoginController {
    /*
    private UserRepositoryJPA userRepositoryJPA;

    @Autowired
    LoginController(UserRepositoryJPA userRepositoryJPA) {
        this.userRepositoryJPA = userRepositoryJPA;
    }
    */

    @PostMapping
    public void loginMethod(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        //request.getSession().invalidate();
        request.login(request.getParameter("username"), request.getParameter("password"));
        log.warn(request.getUserPrincipal().getName());
    }
}
