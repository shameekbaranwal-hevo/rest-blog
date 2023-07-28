package hevo.db;

import hevo.api.Post;
import java.util.List;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.GetGeneratedKeys;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

public interface PostsDAO {
  @SqlUpdate(
      "CREATE TABLE posts ("
          + "id INTEGER PRIMARY KEY AUTO_INCREMENT, "
          + "created_at DATE, "
          + "modified_at DATE, "
          + "user_id INT, "
          + "content VARCHAR(50))")
  void createTable();

  @SqlUpdate(
      "INSERT INTO "
          + "posts(created_at, modified_at, user_id, content) "
          + "VALUES(CURDATE(), "
          + "CURDATE(), "
          + ":userID, "
          + ":content"
          + ")")
  @GetGeneratedKeys
  int insertPost(@Bind("userID") int userID, @Bind("content") String content);

  @SqlQuery("SELECT * FROM posts")
  @UseRowMapper(PostsMapper.class)
  List<Post> getPosts();

  @SqlQuery("SELECT * FROM posts WHERE user_id=:userID")
  @UseRowMapper(PostsMapper.class)
  List<Post> getPostByUserID(@Bind("userID") int userID);

  @SqlQuery("SELECT * FROM posts WHERE id=:id")
  @UseRowMapper(PostsMapper.class)
  Post getPostByID(@Bind("id") int id);
}
