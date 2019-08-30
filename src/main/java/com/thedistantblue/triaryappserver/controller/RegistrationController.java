package com.thedistantblue.triaryappserver.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/registration", consumes = "application/json")
public class RegistrationController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerUser(@RequestBody String json) {

    }

}
