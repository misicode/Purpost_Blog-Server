package com.misicode.purpost.authservice.services.auth;

import com.misicode.purpost.authservice.payload.SigninRequest;
import com.misicode.purpost.authservice.payload.SigninResponse;
import com.misicode.purpost.authservice.services.userdetails.UserDetailsImpl;

public interface IAuthService {
    SigninResponse login(SigninRequest signinRequest);

    SigninResponse checkToken(String token);

    UserDetailsImpl getUserAuthenticated();

    String getUsernameAuthenticated();
}
