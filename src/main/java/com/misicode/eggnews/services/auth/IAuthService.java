package com.misicode.eggnews.services.auth;

import com.misicode.eggnews.domain.UserDetailsImpl;
import com.misicode.eggnews.payload.SigninRequest;
import com.misicode.eggnews.payload.SigninResponse;

public interface IAuthService {
    SigninResponse login(SigninRequest signinRequest);

    UserDetailsImpl getUserAuthenticated();

    String getUsernameAuthenticated();
}
