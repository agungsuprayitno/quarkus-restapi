package restApi.repository;

import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import restApi.models.Post;

@ApplicationScoped
public class PostRepository implements PanacheRepository<Post> {
}
