package com.example.docker.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class HelloController {
    @GetMapping("/hello")
    public Map<String,String> Sayhello() {
        return Collections.singletonMap("message", "Hello world!!! SECOND CHANGE FOR TODAYYY !my name is imen");
    }
    @GetMapping("/hi")
    public Map<String,String> Sayhi() {
        return Collections.singletonMap("message", "Hello world!!! SECOND CHANGE FOR TODAYYY !my name is imen");
    }

    @PostMapping("/submit")
    public Map<String,String> submit() {
        return Collections.singletonMap("message", "Submitted");
    }
}
