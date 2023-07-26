package hevo.api;

import com.fasterxml.jackson.annotation.JsonProperty;

// Representation Class, to be serialized into JSON by Jackson
public class Saying {
  private long id;
  private String content;

  public Saying() {
    // deserialization
  }

  public Saying(long id, String content) {
    this.id = id;
    this.content = content;
  }

  @JsonProperty
  public long getId() {
    return id;
  }

  @JsonProperty
  public String getContent() {
    return content;
  }
}
