package com.misicode.purpost.postservice.infrastructure.adapters.in.rest.controllers;

import com.misicode.purpost.postservice.application.ports.in.PostServicePort;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.request.PostCreateRequest;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.response.PostResponse;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.dtos.request.PostUpdateRequest;
import com.misicode.purpost.postservice.infrastructure.adapters.in.rest.mappers.PostRestMapper;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    private final PostServicePort postServicePort;

    public PostController(PostServicePort postServicePort) {
        this.postServicePort = postServicePort;
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<PostResponse> getPostById(@PathVariable String id) {
        return ResponseEntity.ok(
                PostRestMapper.toPostResponse(
                        postServicePort.findById(id)
                )
        );
    }

    @GetMapping("/username/{username}")
    public ResponseEntity<List<PostResponse>> getPostsByUser(@PathVariable String username) {
        return ResponseEntity.ok(
                PostRestMapper.toListPostResponse(
                        postServicePort.findByUsername(username)
                )
        );
    }

    @GetMapping()
    public ResponseEntity<List<PostResponse>> getPosts() {
        return ResponseEntity.ok(
                PostRestMapper.toListPostResponse(
                        postServicePort.findAll()
                )
        );
    }

    @PostMapping(value="/private", consumes = "multipart/form-data")
    public ResponseEntity<PostResponse> createPost(@ModelAttribute @Valid PostCreateRequest post) {
        return ResponseEntity.ok(
                PostRestMapper.toPostResponse(
                        postServicePort.create(PostRestMapper.toPost(post))
                )
        );
    }

    @PutMapping(value="/private", consumes = "multipart/form-data")
    public ResponseEntity<PostResponse> updatePost(@ModelAttribute @Valid PostUpdateRequest post) {
        return ResponseEntity.ok(
                PostRestMapper.toPostResponse(
                        postServicePort.update(PostRestMapper.toPost(post))
                )
        );
    }

    @DeleteMapping("/private/{id}")
    public ResponseEntity<String> deletePost(@PathVariable String id) {
        postServicePort.deleteById(id);

        return ResponseEntity.ok(
                "Publicación eliminada exitosamente!"
        );
    }
}
