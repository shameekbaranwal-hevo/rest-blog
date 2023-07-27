package hevo.db;

import hevo.api.Post;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

public class PostsMapper implements RowMapper<Post> {

  /**
   * Map the current row of the result set. This method should not cause the result set to advance;
   * allow Jdbi to do that, please.
   *
   * @param rs the result set being iterated
   * @param ctx the statement context
   * @return the value to produce for this row
   * @throws SQLException if anything goes wrong go ahead and let this percolate; Jdbi will handle
   *     it
   */
  @Override
  public Post map(ResultSet rs, StatementContext ctx) throws SQLException {
    return new Post(
        rs.getInt("id"),
        rs.getDate("created_at"),
        rs.getDate("modified_at"),
        rs.getInt("user_id"),
        rs.getString("content"));
  }
}
