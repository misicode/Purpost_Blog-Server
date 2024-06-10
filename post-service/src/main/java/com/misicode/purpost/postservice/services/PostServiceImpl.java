package com.misicode.purpost.postservice.services;

import com.misicode.purpost.postservice.clients.ImageClient;
import com.misicode.purpost.postservice.clients.UserClient;
import com.misicode.purpost.postservice.domain.Post;
import com.misicode.purpost.postservice.dto.ImageResponse;
import com.misicode.purpost.postservice.dto.PostCreateRequest;
import com.misicode.purpost.postservice.dto.PostUpdateRequest;
import com.misicode.purpost.postservice.dto.UserResponse;
import com.misicode.purpost.postservice.exception.ApplicationException;
import com.misicode.purpost.postservice.exception.error.ErrorResponseEnum;
import com.misicode.purpost.postservice.repositories.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PostServiceImpl implements IPostService {
    private final PostRepository postRepository;
    private final UserClient userClient;
    private final ImageClient imageClient;

    public PostServiceImpl(PostRepository postRepository, UserClient userClient, ImageClient imageClient) {
        this.postRepository = postRepository;
        this.userClient = userClient;
        this.imageClient = imageClient;
    }

    @Override
    public List<Post> getPosts() {
        return postRepository.findByIsActiveTrueOrderByCreatedAtDesc();
    }

    @Override
    public Post getPostById(String id) {
        return postRepository.findById(id)
                .orElseThrow(() -> new ApplicationException(ErrorResponseEnum.POST_NOT_FOUND, Map.of("id", id)));
    }

    @Override
    public List<Post> getPostsByUser(String email) {
        try {
            UserResponse user = userClient.getUserByEmail(email);

            return postRepository.findByIdUserAndIsActiveTrueOrderByCreatedAtDesc(user.getIdUser());
        } catch(Exception e) {
            throw new ApplicationException(ErrorResponseEnum.USER_NOT_FOUND, Map.of("email", email));
        }
    }

    @Override
    public Post createPost(PostCreateRequest postRequest) {
        UserResponse user = userClient.getUserByEmail(postRequest.getEmail());
        ImageResponse image = imageClient.saveImage(postRequest.getImage());

        Post post = new Post();
        post.setTitle(postRequest.getTitle());
        post.setBody(postRequest.getBody());
        post.setIdUser(user.getIdUser());
        post.setIdImage(image.getIdImage());

        return postRepository.save(post);
    }

    @Override
    public Post updatePost(PostUpdateRequest postRequest) {
        Post post = getPostById(postRequest.getIdPost());

        post.setTitle(postRequest.getTitle());
        post.setBody(postRequest.getBody());

        if(postRequest.getImage() != null) {
            imageClient.updateImage(post.getIdImage(), postRequest.getImage());
        }

        return postRepository.save(post);
    }

    @Override
    public void deletePost(String id) {
        getPostById(id);
        postRepository.softDelete(id);
    }
}
