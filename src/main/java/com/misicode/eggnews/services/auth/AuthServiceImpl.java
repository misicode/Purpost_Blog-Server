package com.misicode.eggnews.services.auth;

import com.misicode.eggnews.dto.user.UserResponse;
import com.misicode.eggnews.mapper.UserMapper;
import com.misicode.eggnews.services.user.UserServiceImpl;
import com.misicode.eggnews.services.userdetails.UserDetailsImpl;
import com.misicode.eggnews.exception.ApplicationException;
import com.misicode.eggnews.exception.error.ErrorResponseEnum;
import com.misicode.eggnews.payload.SigninRequest;
import com.misicode.eggnews.payload.SigninResponse;
import com.misicode.eggnews.security.jwt.JwtUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
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
    private UserServiceImpl userService;

    public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtils jwtUtils, UserServiceImpl userService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtils = jwtUtils;
        this.userService = userService;
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

            UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

            String token = jwtUtils.generateJwtToken(userDetails.getUsername());

            UserResponse user = UserMapper.mapToUserResponse(userService.getUserByEmail(userDetails.getUsername()));

            return new SigninResponse(token, user);
        } catch(BadCredentialsException e) {
            throw new ApplicationException(ErrorResponseEnum.BAD_CREDENTIALS);
        } catch(AuthenticationException e) {
            throw new ApplicationException(ErrorResponseEnum.AUTH_FAILED, Map.of("message", e.getMessage()));
        }
    }

    @Override
    public SigninResponse checkToken(String token) {
        if(token.startsWith("Bearer ")){
            String splitToken = token.substring(7);

            if(jwtUtils.isValidJwtToken(splitToken)){
                String username = jwtUtils.getUsernameFromToken(splitToken);

                UserResponse user = UserMapper.mapToUserResponse(userService.getUserByEmail(username));

                return new SigninResponse(splitToken, user);
            }
        }

        throw new ApplicationException(ErrorResponseEnum.INVALIDATE_TOKEN);
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
