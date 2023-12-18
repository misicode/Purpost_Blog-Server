package com.misicode.eggnews.controllers;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.domain.UserDetailsImpl;
import com.misicode.eggnews.services.IAuthService;
import com.misicode.eggnews.services.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {
    private IAuthService authService;
    private IUserService userService;

    public AuthController(IAuthService authService, IUserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping("/signin")
    public String showSignIn() {
        return "signin-page";
    }

    @PostMapping("/signin/form")
    public String signIn(UserDetailsImpl userDetails) {
        authService.login(userDetails);
        return "redirect:../home-page";
    }

    @GetMapping("/signup")
    public String showSignUp(ModelMap model) {
        model.addAttribute("user", new User());
        return "signup-page";
    }

    @PostMapping("/signup/form")
    public String signUp(User user) {
        return userService.saveUser(user) ? "redirect:../signin" : "redirect:../signup";
    }
}
