package com.misicode.purpost.userservice.controller;

import com.misicode.purpost.userservice.dto.UserCreateRequest;
import com.misicode.purpost.userservice.dto.UserDataResponse;
import com.misicode.purpost.userservice.dto.UserResponse;
import com.misicode.purpost.userservice.dto.UserUpdateRequest;
import com.misicode.purpost.userservice.mappers.UserDataMapper;
import com.misicode.purpost.userservice.mappers.UserMapper;
import com.misicode.purpost.userservice.services.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final IUserService userService;

    public UserController(IUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id/{id}")
    public Mono<UserResponse> getUserById(@PathVariable String id) {
        return userService.getUserById(id)
                .map(user -> UserMapper.mapToUserResponse(user));
    }

    @GetMapping("/email/{email}")
    public Mono<UserResponse> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email)
                .map(user -> UserMapper.mapToUserResponse(user));
    }

    @GetMapping("/username/{username}")
    public Mono<UserResponse> getUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username)
                .map(user -> UserMapper.mapToUserResponse(user));
    }

    @GetMapping("/private/{account}")
    public Mono<UserDataResponse> getUserDataByUsernameOrEmail(@PathVariable String account) {
        return userService.getUserByUsernameOrEmail(account)
                .map(user -> UserDataMapper.mapToUserDataResponse(user));
    }

    @PostMapping()
    public Mono<UserResponse> createUser(@RequestBody @Valid UserCreateRequest userRequest) {
        return userService.createUser(userRequest)
                .map(user -> UserMapper.mapToUserResponse(user));
    }

    @PutMapping("/private")
    public Mono<UserResponse> updateUser(@RequestBody @Valid UserUpdateRequest userRequest) {
        return userService.updateUser(userRequest)
                .map(user -> UserMapper.mapToUserResponse(user));
    }
}
