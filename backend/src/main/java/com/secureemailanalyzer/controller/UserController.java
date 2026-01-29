package com.secureemailanalyzer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.secureemailanalyzer.service.UserService;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String showRegisterForm(
            @RequestParam(required = false) String username) {

        if (username != null && userService.usernameExists(username)) {
            return "redirect:/login";
        }

        return "register";
    }

    @PostMapping("/register")
    public String register(
            @RequestParam String username,
            @RequestParam String password) {

        if (userService.usernameExists(username)) {
            return "redirect:/register?error";
        }

        userService.registerUser(username, password);

        // on laisse Spring Security gérer l’authentification
        return "redirect:/login";
    }
}
