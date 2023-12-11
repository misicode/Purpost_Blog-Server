package com.misicode.eggnews.repositories;

import com.misicode.eggnews.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
