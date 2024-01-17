package com.misicode.eggnews.controllers;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.dto.UserDto;
import com.misicode.eggnews.services.IAuthService;
import com.misicode.eggnews.services.IUserService;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserController {
    private IAuthService authService;
    private IUserService userService;

    public UserController(IAuthService authService, IUserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @GetMapping("/profile")
    public ResponseEntity<UserDto> getProfile() {
        return ResponseEntity.ok(authService.getUserAuthenticated());
    }

    /*@GetMapping("/my-profile/edit")
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
    }*/
}
