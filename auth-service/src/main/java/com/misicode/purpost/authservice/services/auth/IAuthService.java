package com.misicode.purpost.authservice.services.auth;

import com.misicode.purpost.authservice.payload.LoginRequest;
import com.misicode.purpost.authservice.payload.LoginResponse;
import com.misicode.purpost.authservice.services.userdetails.UserDetailsImpl;

public interface IAuthService {
    LoginResponse login(LoginRequest loginRequest);

    LoginResponse checkToken(String token);

    UserDetailsImpl getUserAuthenticated();

    String getUsernameAuthenticated();
}
