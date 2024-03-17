package com.misicode.purpost.postservice.services;

import com.misicode.purpost.postservice.domain.Post;
import com.misicode.purpost.postservice.dto.PostCreateRequest;

import java.util.List;

public interface IPostService {
    List<Post> getPosts();

    List<Post> getPostByUser(String email);

    Post getPostById(String id);

    Post createPost(PostCreateRequest postRequest);

    Post updatePost(PostCreateRequest postRequest);

    void deletePost(String id);
}
