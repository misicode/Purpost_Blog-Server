package com.misicode.purpost.imageservice.repositories;

import com.misicode.purpost.imageservice.domain.Image;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends MongoRepository<Image, String> {
}
