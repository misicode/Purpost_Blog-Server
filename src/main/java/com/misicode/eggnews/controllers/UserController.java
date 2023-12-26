package com.misicode.eggnews.controllers;

import com.misicode.eggnews.services.IAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    private IAuthService authService;

    public UserController(IAuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/my-profile")
    public String profile(ModelMap model) {
        model.addAttribute("user", authService.getUserAuthenticated());
        return "profile-page";
    }
}
