package com.shea.spotifyAPI.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/home")
@RestController
@CrossOrigin(origins = "*", maxAge = 4800)
public class HomeController {

    @GetMapping("/hello")
    public String home() {
        return "Hello World!";
    }
}