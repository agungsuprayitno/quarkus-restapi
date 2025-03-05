package restApi.resources;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import restApi.models.Post;
import restApi.services.CreatePostService;
import restApi.services.DeletePostService;
import restApi.services.GetPostService;
import restApi.services.UpdatePostService;

import java.util.List;

@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PostResource {

    @Inject
    CreatePostService createPostService;

    @Inject
    GetPostService getPostService;

    @Inject
    UpdatePostService updatePostService;

    @Inject
    DeletePostService deletePostService;

    @GET
    public List<Post> getPerPage(@QueryParam("page") int page, @QueryParam("size") int size){
        return getPostService.getPerPage(page, size);
    }

    @POST
    @Transactional
    public Post create(Post newPost) {
        return createPostService.create(newPost);
    }

    @PUT
    @Path("/{id}")
    @Transactional
    public Post updateById(@PathParam("id") Long id, Post post) {
        return updatePostService.updatePostById(id, post);
    }

    @DELETE
    @Path("/{id}")
    @Transactional
    public boolean updateById(@PathParam("id") Long id) {
        return deletePostService.deleteById(id);
    }
}
