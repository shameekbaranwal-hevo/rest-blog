package hevo.resources;

import com.codahale.metrics.annotation.Timed;
import hevo.api.Post;
import hevo.db.PostsDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import java.util.List;
import java.util.OptionalInt;
import java.util.concurrent.atomic.AtomicLong;
import org.jdbi.v3.core.Jdbi;

@Path("/post")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BlogPostsResource {
  private final AtomicLong counter;
  private final PostsDAO postsDAO;

  public BlogPostsResource(Jdbi jdbi) {
    this.counter = new AtomicLong();
    this.postsDAO = jdbi.onDemand(PostsDAO.class);
  }

  @GET
  @Timed
  public List<Post> getPosts(@QueryParam("userID") OptionalInt userID) {
    return userID.isPresent() ?
            postsDAO.getPostByUserID(userID.getAsInt()) :
            postsDAO.getPosts();
  }

  @GET
  @Path("/{id}")
  public Post getPostByID(@PathParam("id") int id) {
    return postsDAO.getPostByID(id);
  }

  @POST
  @Timed
  public Post createPost(Post p) {
    int k = postsDAO.insertPost(p.getUserID(), p.getContent());
    return postsDAO.getPostByID(k);
  }
}
