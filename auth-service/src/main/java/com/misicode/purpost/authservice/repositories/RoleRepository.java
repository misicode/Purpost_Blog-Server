package com.misicode.purpost.authservice.repositories;

import com.misicode.purpost.authservice.domain.Role;
import com.misicode.purpost.authservice.domain.RoleEnum;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends MongoRepository<Role, String> {
    Optional<Role> findByName(RoleEnum name);
}