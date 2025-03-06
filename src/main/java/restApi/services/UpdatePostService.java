package restApi.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import restApi.dto.UpdatePostRequest;
import restApi.models.Post;
import restApi.repository.PostRepository;

@ApplicationScoped
public class UpdatePostService {

    @Inject
    PostRepository postRepository;

    public Post updatePostById(Long id, UpdatePostRequest newPost) {
        Post existingPost = postRepository.findById(id);
        if (existingPost == null) {
            throw new NotFoundException("Post not found with id: " + id);
        }
        existingPost.setTitle(newPost.getTitle());
        existingPost.setDescription(newPost.getDescription());
        postRepository.persist(existingPost);
        return existingPost;
    }
}
