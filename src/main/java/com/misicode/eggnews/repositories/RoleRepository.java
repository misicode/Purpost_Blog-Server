package com.misicode.eggnews.repositories;

import com.misicode.eggnews.domain.ERole;
import com.misicode.eggnews.domain.Role;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(ERole name);
}
