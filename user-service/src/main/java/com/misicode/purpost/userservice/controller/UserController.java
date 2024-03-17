package com.misicode.purpost.userservice.controller;

import com.misicode.purpost.userservice.dto.UserCreateRequest;
import com.misicode.purpost.userservice.dto.UserResponse;
import com.misicode.purpost.userservice.dto.UserUpdateRequest;
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

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable String id) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.getUserById(id))
        );
    }

    @GetMapping("/{email}")
    public ResponseEntity<UserResponse> getUserByEmail(@PathVariable String email) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.getUserByEmail(email))
        );
    }

    @PostMapping()
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserCreateRequest userRequest) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.createUser(userRequest))
        );
    }

    @PutMapping()
    public ResponseEntity<UserResponse> updateUser(@RequestBody @Valid UserUpdateRequest userRequest) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.updateUser(userRequest))
        );
    }
}
