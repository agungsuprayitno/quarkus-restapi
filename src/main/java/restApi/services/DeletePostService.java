package restApi.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import restApi.repository.PostRepository;

@ApplicationScoped
public class DeletePostService {

    @Inject
    PostRepository postRepository;

    public boolean deleteById(Long id) {
        try{
            postRepository.deleteById(id);
            return true;
        }catch (Exception e) {
            return false;
        }
    }
}
