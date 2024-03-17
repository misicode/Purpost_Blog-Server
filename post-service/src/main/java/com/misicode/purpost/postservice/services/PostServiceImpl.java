package com.misicode.purpost.postservice.services;

import com.misicode.purpost.postservice.clients.UserClient;
import com.misicode.purpost.postservice.domain.Post;
import com.misicode.purpost.postservice.dto.PostCreateRequest;
import com.misicode.purpost.postservice.dto.UserResponse;
import com.misicode.purpost.postservice.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements IPostService {
    private final PostRepository postRepository;
    private final UserClient userClient;

    public PostServiceImpl(PostRepository postRepository, UserClient userClient) {
        this.postRepository = postRepository;
        this.userClient = userClient;
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findByIsActiveTrueOrderByCreatedAtDesc();
    }

    @Override
    public List<Post> getPostByUser(String email) {
        UserResponse user = userClient.getUserByEmail(email);

        return postRepository.findByIdUserAndIsActiveTrueOrderByCreatedAtDesc(user.getIdUser());
    }

    @Override
    public Post getPostById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Publicación no encontrada"));
    }

    @Override
    public Post createPost(PostCreateRequest postRequest) {
        return null;
    }

    @Override
    public Post updatePost(PostCreateRequest postRequest) {
        return null;
    }

    @Override
    public void deletePost(String id) {
        getPostById(id);
        postRepository.softDelete(id);
    }
}
