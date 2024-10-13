package com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.repositories;

import com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.entity.PostEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<PostEntity, String> {
    List<PostEntity> findByIsActiveTrueOrderByCreatedAtDesc();

    List<PostEntity> findByIdUserAndIsActiveTrueOrderByCreatedAtDesc(String idUser);

    @Query("{'_id' : ?0}")
    @Update("{'$set' : {'isActive': false}}")
    void softDelete(@Param("id") String id);
}
