package com.example.docker.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@Controller
public class AppController {
    @GetMapping("/")
    public String hello() {
        return "index";
    }
}
