package com.misicode.purpost.authservice.infrastructure.adapters.in.rest.dtos.response;

public class LoginResponse {
    private String token;

    public LoginResponse(String token) {
        this.token = token;
    }

    public String getToken() {
        return token;
    }
}
