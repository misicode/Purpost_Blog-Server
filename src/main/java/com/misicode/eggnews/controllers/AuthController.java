package com.misicode.eggnews.controllers;

import com.misicode.eggnews.dto.UserResponse;
import com.misicode.eggnews.mapper.UserMapper;
import com.misicode.eggnews.payload.SigninRequest;
import com.misicode.eggnews.payload.SigninResponse;
import com.misicode.eggnews.dto.UserCreateRequest;
import com.misicode.eggnews.services.auth.IAuthService;
import com.misicode.eggnews.services.user.IUserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private IAuthService authService;
    private IUserService userService;

    public AuthController(IAuthService authService, IUserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<SigninResponse> login(@RequestBody @Valid SigninRequest request) {
        SigninResponse response = authService.login(request);

        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, response.getToken()).body(null);
    }

    @PostMapping("/register")
    public ResponseEntity<UserResponse> register(@RequestBody @Valid UserCreateRequest request) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.createUser(request))
        );
    }
}
