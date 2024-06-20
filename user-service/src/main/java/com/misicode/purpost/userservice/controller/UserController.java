package com.misicode.purpost.userservice.controller;

import com.misicode.purpost.userservice.dto.UserCreateRequest;
import com.misicode.purpost.userservice.dto.UserDataResponse;
import com.misicode.purpost.userservice.dto.UserResponse;
import com.misicode.purpost.userservice.dto.UserUpdateRequest;
import com.misicode.purpost.userservice.mappers.UserDataMapper;
import com.misicode.purpost.userservice.mappers.UserMapper;
import com.misicode.purpost.userservice.services.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.getUserById(id))
        );
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.getUserByEmail(email))
        );
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<UserResponse> getUserByUsername(@PathVariable String username) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.getUserByUsername(username))
        );
    }

    @GetMapping("/private/{account}")
    public ResponseEntity<UserDataResponse> getUserDataByUsernameOrEmail(@PathVariable String account) {
        return ResponseEntity.ok(
                UserDataMapper.mapToUserDataResponse(userService.getUserByUsernameOrEmail(account))
        );
    }

    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserCreateRequest userRequest) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.createUser(userRequest))
        );
    }

    @PutMapping("/private")
    public ResponseEntity<UserResponse> updateUser(@RequestBody @Valid UserUpdateRequest userRequest) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.updateUser(userRequest))
        );
    }
}
