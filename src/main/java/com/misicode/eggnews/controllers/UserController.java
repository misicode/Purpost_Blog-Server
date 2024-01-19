package com.misicode.eggnews.controllers;

import com.misicode.eggnews.dto.UserDto;
import com.misicode.eggnews.mapper.UserMapper;
import com.misicode.eggnews.services.auth.IAuthService;
import com.misicode.eggnews.services.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return ResponseEntity.ok(
                UserMapper.mapToUserDto(userService.getUserByEmail(authService.getUsernameAuthenticated()))
        );
    }

    @PutMapping("/profile")
    public ResponseEntity<UserDto> updateProfile(@RequestBody @Valid UserDto user) {
        return ResponseEntity.ok(
                UserMapper.mapToUserDto(userService.updateUser(user, authService.getUsernameAuthenticated()))
        );
    }
}
