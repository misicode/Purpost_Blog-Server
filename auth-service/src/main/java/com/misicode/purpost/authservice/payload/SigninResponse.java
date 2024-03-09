package com.misicode.purpost.authservice.payload;

import com.misicode.purpost.authservice.dto.UserResponse;

public class SigninResponse {
    private String token;
    private UserResponse user;

    public SigninResponse(String token, UserResponse user) {
        this.token = token;
        this.user = user;
    }

    public String getToken() {
        return token;
    }

    public UserResponse getUser() {
        return user;
    }
}
