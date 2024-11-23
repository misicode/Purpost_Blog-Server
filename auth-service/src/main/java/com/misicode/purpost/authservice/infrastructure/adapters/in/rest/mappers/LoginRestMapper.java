package com.misicode.purpost.authservice.infrastructure.adapters.in.rest.mappers;

import com.misicode.purpost.authservice.domain.model.Credentials;
import com.misicode.purpost.authservice.infrastructure.adapters.in.rest.dtos.request.LoginRequest;
import com.misicode.purpost.authservice.infrastructure.adapters.in.rest.dtos.response.LoginResponse;

public class LoginRestMapper {
    public LoginRestMapper() {
        throw new UnsupportedOperationException();
    }

    public static Credentials toCredentials(LoginRequest loginRequest) {
        return new Credentials(
                loginRequest.account(),
                loginRequest.password()
        );
    }

    public static LoginResponse toLoginResponse(String response) {
        return new LoginResponse(response);
    }
}
