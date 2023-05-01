package com.sysmap.api.model.entities;

import com.sysmap.api.model.embedded.Author;
import java.util.UUID;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "users")
@Getter
@Setter
@Data
public class User {

  @Id
  private UUID id;

  @Field
  private String name;

  @Field
  private String email;

  @Field
  private String password;

  @Field
  private Author author;

  public User(String name,String email, String password, Author author) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.email = email;
    this.password = password;
    this.author = author;
  }
}
