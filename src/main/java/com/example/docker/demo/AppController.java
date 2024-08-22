package com.example.docker.demo;

import com.example.docker.demo.user.User;
import com.example.docker.demo.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import java.util.Collections;
import java.util.Map;

@Controller
public class AppController {
    @GetMapping("/")
    public String hello() {
        return "index";
    }

    @GetMapping("/login")
    public String Login() {
        return "login";
    }

    @GetMapping("/signup")
    public String Signup() {
        return "signup";
    }

    @GetMapping("/requests")
    public String Request() {
        return "requests";
    }

    @GetMapping("/users")
    public String DisplayUsers() {
        return "users";
    }

    @GetMapping("/user/{id}")
    public String DisplayUser() {
        return "user";
    }

    @Autowired
    private UserRepo userRepository;
    @PostMapping("api/v1/login")
    public String loginUser(@RequestParam("username") String username,
                            @RequestParam("password") String password) {
        User user = userRepository.findByName(username);
        // Implement your login logic here
        if (user != null)  {
            // Replace with actual authentication logic
            return "index";  // Redirect to a home page after successful login
        } else {
            return "redirect:/login?error";  // Redirect back to login with an error
        }
    }

    @PostMapping("api/v1/signup")
    public String RegisterUser(@RequestParam("username") String username,
                            @RequestParam("c-password") String password) {
        User user = userRepository.findByName(username);
        user.setPassword(password);
        userRepository.save(user);
        // Implement your login logic here
        if (user != null)  {
            // Replace with actual authentication logic
            return "index";  // Redirect to a home page after successful login
        } else {
            return "redirect:/login?error";  // Redirect back to login with an error
        }
    }

}
