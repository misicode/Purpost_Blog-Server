package com.misicode.purpost.postservice.application.services;

import com.misicode.purpost.postservice.application.ports.in.PostServicePort;
import com.misicode.purpost.postservice.application.ports.out.ImageWebClientPort;
import com.misicode.purpost.postservice.application.ports.out.PostPersistencePort;
import com.misicode.purpost.postservice.application.ports.out.UserWebClientPort;
import com.misicode.purpost.postservice.domain.model.Image;
import com.misicode.purpost.postservice.domain.model.Post;
import com.misicode.purpost.postservice.application.exceptions.ApplicationException;
import com.misicode.purpost.postservice.application.exceptions.errors.ErrorCatalog;
import com.misicode.purpost.postservice.domain.model.User;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Map;

@Service
public class PostService implements PostServicePort {
    private final PostPersistencePort postPersistencePort;
    private final UserWebClientPort userWebClientPort;
    private final ImageWebClientPort imageWebClientPort;

    public PostService(PostPersistencePort postPersistencePort, UserWebClientPort userWebClientPort, ImageWebClientPort imageWebClientPort) {
        this.postPersistencePort = postPersistencePort;
        this.userWebClientPort = userWebClientPort;
        this.imageWebClientPort = imageWebClientPort;
    }

    @Override
    public Mono<Post> findById(String id) {
        return postPersistencePort
                .findById(id)
                .switchIfEmpty(Mono.error(
                        new ApplicationException(
                                ErrorCatalog.POST_NOT_FOUND,
                                Map.of("id", id)
                        )
                ))
                .flatMap(post ->
                        Mono.zip(
                                userWebClientPort.findById(post.getUser().getIdUser()),
                                imageWebClientPort.findById(post.getImage().getIdImage()),
                                (user, image) -> {
                                    post.setUser(user);
                                    post.setImage(image);

                                    return post;
                                }
                        )
                );
    }

    @Override
    public Flux<Post> findByUsername(String username) {
        return userWebClientPort
                .findByUsername(username)
                .flatMapMany(user ->
                        postPersistencePort
                                .findByIdUser(user.getIdUser())
                                .flatMap(post ->
                                        imageWebClientPort
                                                .findById(post.getImage().getIdImage())
                                                .map(image -> {
                                                    post.setUser(user);
                                                    post.setImage(image);

                                                    return post;
                                                })
                                )
                )
                .switchIfEmpty(Flux.empty());
    }

    @Override
    public Flux<Post> findAll() {
        return postPersistencePort
                .findAll()
                .flatMap(post ->
                        Mono.zip(
                                userWebClientPort.findById(post.getUser().getIdUser()),
                                imageWebClientPort.findById(post.getImage().getIdImage()),
                                (user, image) -> {
                                    post.setUser(user);
                                    post.setImage(image);

                                    return post;
                                }
                        )
                );
    }

    @Override
    public Mono<Post> create(Post post) {
        return Mono.zip(
                userWebClientPort.findByUsername(post.getUser().getUsername()),
                imageWebClientPort.save(post.getImage().getImage())
        ).flatMap(tuple -> {
                User user = tuple.getT1();
                Image image = tuple.getT2();

                post.setActive(true);
                post.setIdUser(user.getIdUser());
                post.setIdImage(image.getIdImage());

                return postPersistencePort
                        .save(post)
                        .map(newPost -> {
                            newPost.setUser(user);
                            newPost.setImage(image);

                            return newPost;
                        });
        });
    }

    @Override
    public Mono<Post> update(Post post) {
        return postPersistencePort
                .findById(post.getIdPost())
                .switchIfEmpty(Mono.error(
                        new ApplicationException(
                                ErrorCatalog.POST_NOT_FOUND,
                                Map.of("id", post.getIdPost())
                        )
                ))
                .flatMap(updatedPost -> {
                    updatedPost.setTitle(post.getTitle());
                    updatedPost.setBody(post.getBody());

                    Mono<Image> imageMono = (post.getImage().getImage() != null)
                            ? imageWebClientPort.update(updatedPost.getImage().getIdImage(), post.getImage().getImage())
                            : imageWebClientPort.findById(updatedPost.getImage().getIdImage());

                    return imageMono
                            .flatMap(image -> {
                                updatedPost.setIdImage(image.getIdImage());

                                return postPersistencePort
                                        .save(updatedPost)
                                        .flatMap(newPost ->
                                                userWebClientPort
                                                        .findById(newPost.getUser().getIdUser())
                                                        .map(user -> {
                                                            newPost.setUser(user);
                                                            newPost.setImage(image);

                                                            return newPost;
                                                        })
                                        );
                            });
                });
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return postPersistencePort
                .findById(id)
                .switchIfEmpty(Mono.error(
                        new ApplicationException(
                                ErrorCatalog.POST_NOT_FOUND,
                                Map.of("id", id)
                        )
                ))
                .flatMap(post -> postPersistencePort.deleteById(id));
    }
}
