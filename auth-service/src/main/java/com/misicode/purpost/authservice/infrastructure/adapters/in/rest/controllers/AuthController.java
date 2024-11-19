package com.misicode.purpost.authservice.infrastructure.adapters.in.rest.controllers;

import com.misicode.purpost.authservice.application.ports.in.AuthServicePort;
import com.misicode.purpost.authservice.infrastructure.adapters.in.rest.dtos.request.LoginRequest;
import com.misicode.purpost.authservice.infrastructure.adapters.in.rest.dtos.response.LoginResponse;
import com.misicode.purpost.authservice.infrastructure.adapters.in.rest.mappers.LoginRestMapper;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthServicePort authServicePort;

    public AuthController(AuthServicePort authServicePort) {
        this.authServicePort = authServicePort;
    }

    @PostMapping("/login")
    public Mono<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        return authServicePort
                .login(LoginRestMapper.toCredentials(request))
                .map(LoginRestMapper::toLoginResponse);
    }

    @GetMapping("/token")
    public Mono<LoginResponse> checkToken(@RequestHeader(name = "Authorization") @NotNull String token) {
        return authServicePort
                .checkToken(token)
                .map(LoginRestMapper::toLoginResponse);
    }
}
