package com.misicode.eggnews.controllers;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.services.IAuthService;
import com.misicode.eggnews.services.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private IAuthService authService;
    private IUserService userService;

    public UserController(IAuthService authService, IUserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping("/my-profile")
    public String profile(ModelMap model) {
        model.addAttribute("user", authService.getUserAuthenticated());
        return "profile-page";
    }

    @GetMapping("/my-profile/edit")
    public String showEditProfile(ModelMap model) {
        model.addAttribute("user", authService.getUserAuthenticated());
        model.addAttribute("isEditable", true);
        return "profile-page";
    }

    @PostMapping("/my-profile/form")
    public String editProfile(User user) {
        User authUser = authService.getUserAuthenticated();

        authUser.setNames(user.getNames());
        authUser.setSurnames(user.getSurnames());

        userService.saveUser(authUser);
        return "redirect:../my-profile";
    }
}
