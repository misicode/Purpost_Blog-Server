package com.misicode.eggnews.services.role;

import com.misicode.eggnews.domain.RoleEnum;
import com.misicode.eggnews.domain.Role;

public interface IRoleService {
    Role getRoleByName(RoleEnum name);
}
