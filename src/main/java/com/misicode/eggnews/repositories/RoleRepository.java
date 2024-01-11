package com.misicode.eggnews.repositories;

import com.misicode.eggnews.domain.RoleEnum;
import com.misicode.eggnews.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(RoleEnum name);
}
