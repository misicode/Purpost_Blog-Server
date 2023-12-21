package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.UserDetailsImpl;
import com.misicode.eggnews.payload.SigninRequest;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    private AuthenticationManager authenticationManager;

    public AuthServiceImpl(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Override
    public void login(SigninRequest signinRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signinRequest.getEmail(),
                            signinRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();

            //String token = jwtUtils.generateJwtToken(user.getUsername());
            //response.setHeader("Authorization", "Bearer " + token);
        } catch (AuthenticationException e) {
            System.out.println("Error de autenticación: " + e.getMessage());
        }
    }
}
