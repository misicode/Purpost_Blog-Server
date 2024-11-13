package com.misicode.purpost.imageservice.infrastructure.adapters.out.persistence.repositories;

import com.misicode.purpost.imageservice.infrastructure.adapters.out.persistence.entity.ImageEntity;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends ReactiveMongoRepository<ImageEntity, String> {
}
