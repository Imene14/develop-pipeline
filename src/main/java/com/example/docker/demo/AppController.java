package com.example.docker.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping
    public String hello() {
        return "Hello World from vm, my name is Imen, how are you, I am fine thank uu";
    }
}
