package com.misicode.eggnews.services;

import com.misicode.eggnews.domain.ERole;
import com.misicode.eggnews.domain.Role;

public interface IRoleService {
    Role getRoleByName(ERole name);
}
