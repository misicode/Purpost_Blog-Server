package com.misicode.purpost.userservice.services.role;

import com.misicode.purpost.userservice.domain.Role;
import com.misicode.purpost.userservice.domain.RoleEnum;
import reactor.core.publisher.Mono;

public interface IRoleService {
    Mono<Role> getRoleByName(RoleEnum name);
}
