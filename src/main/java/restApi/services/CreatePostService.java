package restApi.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import restApi.models.Post;
import restApi.repository.PostRepository;

@ApplicationScoped
public class CreatePostService {

    @Inject
    PostRepository postRepository;

    public Post create(Post newPost) {
        postRepository.persist(newPost);
        return newPost;
    }
}
