package hevo.resources;

import com.codahale.metrics.annotation.Timed;
import hevo.api.Post;
import hevo.db.PostsDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
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
  public List<Post> getPosts() {
    ArrayList<Post> list = new ArrayList<>();
    list.add(new Post(1, new Date(), new Date(), 7, "hello"));
    return list;
  }
}
