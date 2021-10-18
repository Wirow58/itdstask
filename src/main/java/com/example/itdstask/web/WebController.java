package com.example.itdstask.web;

import com.example.itdstask.user.UserDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WebController {

    @GetMapping("users/{login}")
    public UserDTO getUser() {
        return null;
    }

}
