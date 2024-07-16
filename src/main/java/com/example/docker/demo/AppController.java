package com.example.docker.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {
    @GetMapping
    public String hello() {
        return "HIII!!! my name is Imen, HII !!!";
    }
}
