package com.misicode.purpost.postservice.infrastructure.adapters.out.persistence;

import com.misicode.purpost.postservice.application.ports.out.PostPersistencePort;
import com.misicode.purpost.postservice.domain.model.Post;
import com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.mappers.PostPersistenceMapper;
import com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.repositories.PostRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class PostPersistenceAdapter implements PostPersistencePort {
    private final PostRepository postRepository;

    public PostPersistenceAdapter(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Optional<Post> findById(String id) {
        return postRepository
                .findById(id)
                .map(PostPersistenceMapper::toPost);
    }

    @Override
    public List<Post> findByIdUser(String idUser) {
        return postRepository
                .findByIdUserAndIsActiveTrueOrderByCreatedAtDesc(idUser)
                .stream()
                .map(PostPersistenceMapper::toPost)
                .collect(Collectors.toList());
    }

    @Override
    public List<Post> findAll() {
        return postRepository
                .findByIsActiveTrueOrderByCreatedAtDesc()
                .stream()
                .map(PostPersistenceMapper::toPost)
                .collect(Collectors.toList());
    }

    @Override
    public Post save(Post post) {
        return PostPersistenceMapper.toPost(
                postRepository.save(PostPersistenceMapper.toPostEntity(post))
        );
    }

    @Override
    public void deleteById(String id) {
        postRepository.softDelete(id);
    }
}
