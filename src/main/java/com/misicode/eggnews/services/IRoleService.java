package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.RoleEnum;
import com.misicode.eggnews.domain.Role;

public interface IRoleService {
    Role getRoleByName(RoleEnum name);
}
