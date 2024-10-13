package com.misicode.purpost.postservice.infrastructure.adapters.out.client.mappers;

import com.misicode.purpost.postservice.domain.model.User;
import com.misicode.purpost.postservice.infrastructure.adapters.out.client.dtos.response.UserClientResponse;

public class UserClientMapper {
    public UserClientMapper() {
        throw new UnsupportedOperationException();
    }

    public static User toUser(UserClientResponse userClientResponse) {
        return new User(
                userClientResponse.getIdUser(),
                userClientResponse.getUsername(),
                userClientResponse.getNames(),
                userClientResponse.getSurnames()
        );
    }
}
