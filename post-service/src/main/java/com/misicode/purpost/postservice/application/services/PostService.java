package com.misicode.purpost.postservice.application.services;

import com.misicode.purpost.postservice.application.ports.in.PostServicePort;
import com.misicode.purpost.postservice.application.ports.out.ImageClientPort;
import com.misicode.purpost.postservice.application.ports.out.PostPersistencePort;
import com.misicode.purpost.postservice.application.ports.out.UserClientPort;
import com.misicode.purpost.postservice.domain.model.Image;
import com.misicode.purpost.postservice.domain.model.Post;
import com.misicode.purpost.postservice.application.exceptions.ApplicationException;
import com.misicode.purpost.postservice.application.exceptions.errors.ErrorCatalog;
import com.misicode.purpost.postservice.domain.model.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PostService implements PostServicePort {
    private final PostPersistencePort postPersistencePort;
    private final UserClientPort userClientPort;
    private final ImageClientPort imageClientPort;

    public PostService(PostPersistencePort postPersistencePort, UserClientPort userClientPort, ImageClientPort imageClientPort) {
        this.postPersistencePort = postPersistencePort;
        this.userClientPort = userClientPort;
        this.imageClientPort = imageClientPort;
    }

    @Override
    public Post findById(String id) {
        Post post = postPersistencePort
                .findById(id)
                .orElseThrow(
                        () -> new ApplicationException(ErrorCatalog.POST_NOT_FOUND, Map.of("id", id))
                );

        User user = userClientPort.findById(post.getUser().getIdUser());
        Image image = imageClientPort.findById(post.getImage().getIdImage());

        post.setUser(user);
        post.setImage(image);

        return post;
    }

    @Override
    public List<Post> findByUsername(String username) {
        try {
            User user = userClientPort.findByUsername(username);

            List<Post> postList = postPersistencePort.findByIdUser(user.getIdUser());

            return postList
                    .stream()
                    .map(post -> {
                        Image image = imageClientPort.findById(post.getImage().getIdImage());

                        post.setUser(user);
                        post.setImage(image);

                        return post;
                    })
                    .collect(Collectors.toList());
        } catch(Exception e) {
            throw new ApplicationException(
                    ErrorCatalog.USER_NOT_FOUND, Map.of("username", username)
            );
        }
    }

    @Override
    public List<Post> findAll() {
        List<Post> postList = postPersistencePort.findAll();

        return postList
                .stream()
                .map(post -> {
                    User user = userClientPort.findById(post.getUser().getIdUser());
                    Image image = imageClientPort.findById(post.getImage().getIdImage());

                    post.setUser(user);
                    post.setImage(image);

                    return post;
                })
                .collect(Collectors.toList());
    }

    @Override
    public Post create(Post post) {
        User user = userClientPort.findByUsername(post.getUser().getUsername());
        Image image = imageClientPort.save(post.getImage().getImageFile());

        post.setActive(true);
        post.setIdUser(user.getIdUser());
        post.setIdImage(image.getIdImage());

        Post newPost = postPersistencePort.save(post);

        newPost.setUser(user);
        newPost.setImage(image);

        return newPost;
    }

    @Override
    public Post update(Post post) {
        Post updatedPost = postPersistencePort
                .findById(post.getIdPost())
                .orElseThrow(
                        () -> new ApplicationException(ErrorCatalog.POST_NOT_FOUND, Map.of("id", post.getIdPost()))
                );
        Image image = null;

        updatedPost.setTitle(post.getTitle());
        updatedPost.setBody(post.getBody());

        if(post.getImage().getImageFile() != null) {
            image = imageClientPort.update(updatedPost.getImage().getIdImage(), post.getImage().getImageFile());
            updatedPost.setIdImage(image.getIdImage());
        } else {
            image = imageClientPort.findById(updatedPost.getImage().getIdImage());
        }

        Post newPost = postPersistencePort.save(updatedPost);
        User user = userClientPort.findById(newPost.getUser().getIdUser());

        newPost.setUser(user);
        newPost.setImage(image);

        return newPost;
    }

    @Override
    public void deleteById(String id) {
        if(postPersistencePort.findById(id).isPresent()) {
            postPersistencePort.deleteById(id);
        } else {
            throw new ApplicationException(ErrorCatalog.POST_NOT_FOUND, Map.of("id", id));
        }
    }
}
