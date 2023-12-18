package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.UserDetailsImpl;
import com.misicode.eggnews.security.jwt.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    private AuthenticationManager authenticationManager;
    private JwtUtils jwtUtils;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public void login(UserDetailsImpl userDetails) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        userDetails.getUsername(),
                        userDetails.getPassword()
                )
        );

        SecurityContextHolder.getContext().setAuthentication(authentication);

        //UserDetailsImpl user = userRepository.findByUsername(request.getUsername()).orElseThrow();

        //String token = jwtUtils.generateJwtToken(user);
    }
}
