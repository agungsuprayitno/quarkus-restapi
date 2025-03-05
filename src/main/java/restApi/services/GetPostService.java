package restApi.services;

import io.quarkus.panache.common.Page;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.NotFoundException;
import restApi.models.Post;
import restApi.repository.PostRepository;

import java.util.List;

@ApplicationScoped
public class GetPostService {

    @Inject
    PostRepository postRepository;

    public Post getById(Long id) {
        try {
            return postRepository.findById(id);
        } catch (Exception e) {
            throw new NotFoundException("Post Not Found");
        }
    }
    public List<Post> getPerPage(Integer page, Integer size) {
        return postRepository.findAll().page(Page.of(page, size)).list();
    }
}
