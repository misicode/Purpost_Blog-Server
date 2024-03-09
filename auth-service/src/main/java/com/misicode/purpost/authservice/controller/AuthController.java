package com.misicode.purpost.authservice.controller;

import com.misicode.purpost.authservice.payload.SigninRequest;
import com.misicode.purpost.authservice.payload.SigninResponse;
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
    public ResponseEntity<SigninResponse> login(@RequestBody @Valid SigninRequest request) {
        return ResponseEntity.ok(
                authService.login(request)
        );
    }

    @GetMapping("/token")
    public ResponseEntity<SigninResponse> checkToken(@RequestHeader(name = "Authorization") @NotNull String token) {
        return ResponseEntity.ok(
                authService.checkToken(token)
        );
    }
}
