package com.misicode.eggnews.controllers;

import com.misicode.eggnews.dto.UserResponse;
import com.misicode.eggnews.mapper.UserMapper;
import com.misicode.eggnews.payload.SigninRequest;
import com.misicode.eggnews.payload.SigninResponse;
import com.misicode.eggnews.dto.UserCreateRequest;
import com.misicode.eggnews.services.auth.IAuthService;
import com.misicode.eggnews.services.user.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@Tag(
        name = "Auth Controller",
        description = "Controlador con las rutas de las peticiones de autenticación:" +
                "\n- Login" +
                "\n- Registro"
)
public class AuthController {
    private IAuthService authService;
    private IUserService userService;

    public AuthController(IAuthService authService, IUserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @PostMapping("/login")
    @Operation(
            summary = "Login",
            description = "Esta petición permite loguear un usuario y obtener un token de acceso."
    )
    public ResponseEntity<SigninResponse> login(@RequestBody @Valid SigninRequest request) {
        SigninResponse response = authService.login(request);

        return ResponseEntity.ok().header(HttpHeaders.AUTHORIZATION, response.getToken()).body(null);
    }

    @PostMapping("/register")
    @Operation(
            summary = "Registro",
            description = "Esta petición permite registrar un usuario."
    )
    public ResponseEntity<UserResponse> register(@RequestBody @Valid UserCreateRequest request) {
        return ResponseEntity.ok(
                UserMapper.mapToUserResponse(userService.createUser(request))
        );
    }
}
