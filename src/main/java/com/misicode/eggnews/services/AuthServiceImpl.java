package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.User;
import com.misicode.eggnews.domain.UserDetailsImpl;
import com.misicode.eggnews.payload.SigninRequest;
import com.misicode.eggnews.payload.SigninResponse;
import com.misicode.eggnews.security.jwt.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements IAuthService {
    private AuthenticationManager authenticationManager;
    private IUserService userService;
    private JwtUtils jwtUtils;

    public AuthServiceImpl(AuthenticationManager authenticationManager, IUserService userService, JwtUtils jwtUtils) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtils = jwtUtils;
    }

    @Override
    public SigninResponse login(SigninRequest signinRequest) {
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
    }

    @Override
    public User getUserAuthenticated() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        return userService.getUserByEmail(userDetails.getUsername());
    }
}
