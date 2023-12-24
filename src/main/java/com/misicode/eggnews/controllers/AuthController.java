package com.misicode.eggnews.controllers;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.services.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private IUserService userService;

    public AuthController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/signin")
    public String showSignIn() {
        return "signin-page";
    }

    @GetMapping("/signin/error")
    public String showSignInError(ModelMap model) {
        model.addAttribute("isSignInError", true);
        return "signin-page";
    }

    @GetMapping("/signup")
    public String showSignUp(ModelMap model) {
        model.addAttribute("user", new User());
        return "signup-page";
    }

    @GetMapping("/signup/error")
    public String showSignUpError(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("isSignUpError", true);
        return "signup-page";
    }

    @PostMapping("/signup/form")
    public String signUp(User user) {
        return userService.saveUser(user) ? "redirect:../signin" : "redirect:./error";
    }
}
