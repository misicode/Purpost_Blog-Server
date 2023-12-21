package com.misicode.eggnews.repositories;

import com.misicode.eggnews.domain.ERole;
import com.misicode.eggnews.domain.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {
    Optional<Role> findByName(ERole name);
}
