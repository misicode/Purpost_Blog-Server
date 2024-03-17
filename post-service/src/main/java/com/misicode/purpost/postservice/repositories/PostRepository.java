package com.misicode.purpost.postservice.repositories;

import com.misicode.purpost.postservice.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.Update;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByIsActiveTrueOrderByCreatedAtDesc();

    List<Post> findByIdUserAndIsActiveTrueOrderByCreatedAtDesc(String idUser);

    @Query("{'_id' : ?0}")
    @Update("{'$set' : {'isActive': false}}")
    void softDelete(@Param("id") String id);
}