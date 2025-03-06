package restApi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import restApi.dto.CreatePostRequest;
import restApi.models.Post;
import restApi.repository.PostRepository;

@ApplicationScoped
public class CreatePostService {

    @Inject
    PostRepository postRepository;

    public Post create(CreatePostRequest createdPost) {

        ObjectMapper objectMapper = new ObjectMapper();
        Post newPost = objectMapper.convertValue(createdPost, Post.class);
        postRepository.persist(newPost);
        return newPost;
    }
}
