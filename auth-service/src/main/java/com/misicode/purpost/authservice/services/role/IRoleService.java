package com.misicode.purpost.authservice.services.role;

import com.misicode.purpost.authservice.domain.Role;
import com.misicode.purpost.authservice.domain.RoleEnum;

public interface IRoleService {
    Role getRoleByName(RoleEnum name);
}
