package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.controllers;

import com.misicode.purpost.postservice.application.ports.in.PostServicePort;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.request.PostCreateRequest;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.response.PostResponse;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.request.PostUpdateRequest;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.mappers.PostRestMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostServicePort postServicePort;

    public PostController(PostServicePort postServicePort) {
        this.postServicePort = postServicePort;
    }

    @GetMapping("/id/{id}")
    public Mono<PostResponse> getPostById(@PathVariable String id) {
        return postServicePort
                .findById(id)
                .map(PostRestMapper::toPostResponse);
    }

    @GetMapping("/username/{username}")
    public Flux<PostResponse> getPostsByUser(@PathVariable String username) {
        return postServicePort
                .findByUsername(username)
                .map(PostRestMapper::toPostResponse);
    }

    @GetMapping()
    public Flux<PostResponse> getPosts() {
        return postServicePort
                .findAll()
                .map(PostRestMapper::toPostResponse);
    }

    @PostMapping(value="/private", consumes = "multipart/form-data")
    public Mono<PostResponse> createPost(@ModelAttribute @Valid PostCreateRequest postRequest) {
        return postServicePort
                .create(PostRestMapper.toPost(postRequest))
                .map(PostRestMapper::toPostResponse);
    }

    @PutMapping(value="/private", consumes = "multipart/form-data")
    public Mono<PostResponse> updatePost(@ModelAttribute @Valid PostUpdateRequest postRequest) {
        return postServicePort
                .update(PostRestMapper.toPost(postRequest))
                .map(PostRestMapper::toPostResponse);
    }

    @DeleteMapping("/private/{id}")
    public Mono<String> deletePost(@PathVariable String id) {
        return postServicePort
                .deleteById(id)
                .then(Mono.just("Publicación eliminada exitosamente"));
    }
}
