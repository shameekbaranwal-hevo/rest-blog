package hevo.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.text.SimpleDateFormat;
import java.util.Date;

// Representation Class, for serialization into JSON by Jackson
public class Post {
  private int id;
  private String createdAt;
  private String modifiedAt;
  private int userID;
  private String content;

  public Post() {}

  public Post(int id, Date createdAt, Date modifiedAt, int userID, String content) {
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    this.id = id;
    this.createdAt = sdf.format(createdAt);
    this.modifiedAt = sdf.format(modifiedAt);
    this.userID = userID;
    this.content = content;
  }

  @JsonProperty
  public int getId() {
    return id;
  }

  @JsonProperty
  public String getCreatedAt() {
    return createdAt;
  }

  @JsonProperty
  public String getModifiedAt() {
    return modifiedAt;
  }

  @JsonProperty
  public int getUserID() {
    return userID;
  }

  @JsonProperty
  public String getContent() {
    return content;
  }
}
