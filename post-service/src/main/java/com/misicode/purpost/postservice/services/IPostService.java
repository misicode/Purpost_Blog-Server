package com.misicode.purpost.postservice.services;

import com.misicode.purpost.postservice.domain.Post;
import com.misicode.purpost.postservice.dto.PostCreateRequest;
import com.misicode.purpost.postservice.dto.PostUpdateRequest;

import java.util.List;

public interface IPostService {
    List<Post> getPosts();

    List<Post> getPostsByUser(String username);

    Post getPostById(String id);

    Post createPost(PostCreateRequest postRequest);

    Post updatePost(PostUpdateRequest postRequest);

    void deletePost(String id);
}
