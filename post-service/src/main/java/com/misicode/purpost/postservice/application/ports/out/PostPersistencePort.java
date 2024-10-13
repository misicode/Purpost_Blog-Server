package com.misicode.purpost.postservice.application.ports.out;

import com.misicode.purpost.postservice.domain.model.Post;

import java.util.List;
import java.util.Optional;

public interface PostPersistencePort {
    Optional<Post> findById(String id);

    List<Post> findByIdUser(String idUser);

    List<Post> findAll();

    Post save(Post post);

    void deleteById(String id);
}
