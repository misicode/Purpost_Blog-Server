package com.misicode.purpost.userservice.services.role;

import com.misicode.purpost.userservice.domain.Role;
import com.misicode.purpost.userservice.domain.RoleEnum;

public interface IRoleService {
    Role getRoleByName(RoleEnum name);
}
