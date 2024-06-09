package com.misicode.purpost.authservice.services.auth;

import com.misicode.purpost.authservice.clients.UserClient;
import com.misicode.purpost.authservice.exception.ApplicationException;
import com.misicode.purpost.authservice.exception.error.ErrorResponseEnum;
import com.misicode.purpost.authservice.payload.LoginRequest;
import com.misicode.purpost.authservice.payload.LoginResponse;
import com.misicode.purpost.authservice.util.JwtUtil;
import com.misicode.purpost.authservice.services.userdetails.UserDetailsImpl;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AuthServiceImpl implements IAuthService {
    private AuthenticationManager authenticationManager;
    private JwtUtil jwtUtil;
    private UserClient userClient;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtil jwtUtil, UserClient userClient) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userClient = userClient;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getEmail(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtil.generateJwtToken(userDetails.getUsername());

            return new LoginResponse(token);
        } catch(AuthenticationException e) {
            throw new ApplicationException(ErrorResponseEnum.AUTH_FAILED, Map.of("message", e.getMessage()));
        }
    }

    @Override
    public LoginResponse checkToken(String token) {
        if(token.startsWith("Bearer ")){
            String splitToken = token.substring(7);

            if(jwtUtil.isValidJwtToken(splitToken)){
                //String username = jwtUtils.getUsernameFromToken(splitToken);

                //UserDto user = userClient.getUserByEmail(username);

                //return new LoginResponse(splitToken, user);
                return new LoginResponse(splitToken);
            }
        }

        throw new RuntimeException("Token inválido");
    }

    @Override
    public UserDetailsImpl getUserAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return (UserDetailsImpl) authentication.getPrincipal();
    }

    @Override
    public String getUsernameAuthenticated() {
        return getUserAuthenticated().getUsername();
    }
}
