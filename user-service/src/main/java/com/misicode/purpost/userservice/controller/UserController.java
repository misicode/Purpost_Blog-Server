package com.misicode.purpost.userservice.controller;

import com.misicode.purpost.userservice.services.user.IUserService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    private IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }


}
