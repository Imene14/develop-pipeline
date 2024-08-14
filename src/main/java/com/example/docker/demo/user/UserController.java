package com.example.docker.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepo userRepository;
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}
