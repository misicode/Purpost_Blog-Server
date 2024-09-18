package com.misicode.purpost.userservice.infrastructure.adapters.in.rest.controllers;

import com.misicode.purpost.userservice.application.ports.in.UserServicePort;
import com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.request.UserCreateRequest;
import com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.response.UserDataResponse;
import com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.response.UserResponse;
import com.misicode.purpost.userservice.infrastructure.adapters.in.rest.dtos.request.UserUpdateRequest;
import com.misicode.purpost.userservice.infrastructure.adapters.in.rest.mappers.UserDataRestMapper;
import com.misicode.purpost.userservice.infrastructure.adapters.in.rest.mappers.UserRestMapper;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServicePort userServicePort;

    public UserController(UserServicePort userServicePort) {
        this.userServicePort = userServicePort;
    }

    @GetMapping("/id/{id}")
    public Mono<UserResponse> getUserById(@PathVariable String id) {
        return userServicePort
                .findById(id)
                .map(UserRestMapper::toUserResponse);
    }

    @GetMapping("/username/{username}")
    public Mono<UserResponse> getUserByUsername(@PathVariable String username) {
        return userServicePort
                .findByUsername(username)
                .map(UserRestMapper::toUserResponse);
    }

    @GetMapping("/private/{account}")
    public Mono<UserDataResponse> getUserDataByUsernameOrEmail(@PathVariable String account) {
        return userServicePort
                .findByUsernameOrEmail(account)
                .map(UserDataRestMapper::toUserDataResponse);
    }

    @PostMapping()
    public Mono<UserResponse> createUser(@RequestBody @Valid UserCreateRequest userRequest) {
        return userServicePort
                .create(UserRestMapper.toUser(userRequest))
                .map(UserRestMapper::toUserResponse);
    }

    @PutMapping("/private")
    public Mono<UserResponse> updateUser(@RequestBody @Valid UserUpdateRequest userRequest) {
        return userServicePort
                .update(UserRestMapper.toUser(userRequest))
                .map(UserRestMapper::toUserResponse);
    }
}
