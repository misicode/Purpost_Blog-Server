package com.misicode.eggnews.services.auth;

import com.misicode.eggnews.services.userdetails.UserDetailsImpl;
import com.misicode.eggnews.payload.SigninRequest;
import com.misicode.eggnews.payload.SigninResponse;

public interface IAuthService {
    SigninResponse login(SigninRequest signinRequest);

    SigninResponse checkToken(String token);

    UserDetailsImpl getUserAuthenticated();

    String getUsernameAuthenticated();
}
