package com.example.itdstask.web;

import com.example.itdstask.exception.JsonParseException;
import com.example.itdstask.exception.UserNotFoundException;
import com.example.itdstask.user.UserDTO;
import com.example.itdstask.user.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    private final UserService service;

    public WebController(UserService service) {
        this.service = service;
    }

    @GetMapping("users/{login}")
    public UserDTO getUser(@PathVariable String login) throws UserNotFoundException, JsonParseException {
        return service.getUser(login);
    }

}
