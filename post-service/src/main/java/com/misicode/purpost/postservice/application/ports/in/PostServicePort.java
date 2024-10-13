package com.misicode.purpost.postservice.application.ports.in;

import com.misicode.purpost.postservice.domain.model.Post;

import java.util.List;

public interface PostServicePort {
    Post findById(String id);

    List<Post> findByUsername(String username);

    List<Post> findAll();

    Post create(Post post);

    Post update(Post post);

    void deleteById(String id);
}
