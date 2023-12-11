package com.misicode.eggnews.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @GetMapping("/signin")
    public String showSignIn() {
        return "signin-page";
    }

    @GetMapping("/signup")
    public String showSignUp() {
        return "signup-page";
    }
}
