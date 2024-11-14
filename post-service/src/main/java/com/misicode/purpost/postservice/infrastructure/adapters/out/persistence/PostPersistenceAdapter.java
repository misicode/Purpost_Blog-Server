package com.misicode.purpost.postservice.infrastructure.adapters.out.persistence;

import com.misicode.purpost.postservice.application.ports.out.PostPersistencePort;
import com.misicode.purpost.postservice.domain.model.Post;
import com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.entity.PostEntity;
import com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.mappers.PostPersistenceMapper;
import com.misicode.purpost.postservice.infrastructure.adapters.out.persistence.repositories.PostRepository;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class PostPersistenceAdapter implements PostPersistencePort {
    private final PostRepository postRepository;
    private final ReactiveMongoTemplate mongoTemplate;

    public PostPersistenceAdapter(PostRepository postRepository, ReactiveMongoTemplate mongoTemplate) {
        this.postRepository = postRepository;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public Mono<Post> findById(String id) {
        return postRepository
                .findById(id)
                .map(PostPersistenceMapper::toPost);
    }

    @Override
    public Flux<Post> findByIdUser(String idUser) {
        return postRepository
                .findByIdUserAndIsActiveTrueOrderByCreatedAtDesc(idUser)
                .map(PostPersistenceMapper::toPost);
    }

    @Override
    public Flux<Post> findAll() {
        return postRepository
                .findByIsActiveTrueOrderByCreatedAtDesc()
                .map(PostPersistenceMapper::toPost);
    }

    @Override
    public Mono<Post> save(Post post) {
        return postRepository
                .save(PostPersistenceMapper.toPostEntity(post))
                .map(PostPersistenceMapper::toPost);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        Query query = new Query(Criteria.where("_id").is(id));
        Update update = new Update().set("isActive", false);

        return mongoTemplate
                .updateFirst(query, update, PostEntity.class)
                .then();
    }
}
