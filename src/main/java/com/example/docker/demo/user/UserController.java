package com.example.docker.demo.user;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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


    @PostMapping("/login1")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        User user = userRepository.findByName(username);
        // Implement your login logic here
        if (user != null)  {
            // Replace with actual authentication logic
            return "redirect:/index";  // Redirect to a home page after successful login
        } else {
            return "redirect:/login?error";  // Redirect back to login with an error
        }
    }
}
