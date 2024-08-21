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
    @ResponseBody
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
