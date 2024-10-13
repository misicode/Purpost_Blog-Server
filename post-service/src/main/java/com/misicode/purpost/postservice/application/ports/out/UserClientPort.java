package com.misicode.purpost.postservice.application.ports.out;

import com.misicode.purpost.postservice.domain.model.User;

public interface UserClientPort {
    User findById(String id);

    User findByUsername(String username);
}
