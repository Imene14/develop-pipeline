package com.example.docker.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class UserController {
    @Autowired
    private UserRepo userRepository;


    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Autowired
    private UserService userService;
    @PostMapping(value = "/login", consumes = "application/json")
    public String loginUser(@RequestBody User loginRequest) {
        User user = userService.findByUsername(loginRequest.getName());
        if (user != null ) {
            return "Login successful";
        } else {
            return "Invalid username or password";
        }
    }
}
