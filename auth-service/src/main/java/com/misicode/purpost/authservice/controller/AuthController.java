package com.misicode.purpost.authservice.controller;

import com.misicode.purpost.authservice.payload.LoginRequest;
import com.misicode.purpost.authservice.payload.LoginResponse;
import com.misicode.purpost.authservice.services.auth.IAuthService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {
    private IAuthService authService;

    public AuthController(IAuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request) {
        return ResponseEntity.ok(
                authService.login(request)
        );
    }

    @GetMapping("/token")
    public ResponseEntity<LoginResponse> checkToken(@RequestHeader(name = "Authorization") @NotNull String token) {
        return ResponseEntity.ok(
                authService.checkToken(token)
        );
    }
}
