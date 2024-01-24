package com.misicode.eggnews.services.auth;

import com.misicode.eggnews.services.userdetails.UserDetailsImpl;
import com.misicode.eggnews.exception.ApplicationException;
import com.misicode.eggnews.exception.error.ErrorResponseEnum;
import com.misicode.eggnews.payload.SigninRequest;
import com.misicode.eggnews.payload.SigninResponse;
import com.misicode.eggnews.security.jwt.JwtUtils;
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
    private JwtUtils jwtUtils;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public SigninResponse login(SigninRequest signinRequest) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            signinRequest.getEmail(),
                            signinRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            UserDetailsImpl user = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateJwtToken(user.getUsername());

            return new SigninResponse(token);
        } catch(AuthenticationException e) {
            throw new ApplicationException(ErrorResponseEnum.AUTH_FAILED, Map.of("message", e.getMessage()));
        }
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
