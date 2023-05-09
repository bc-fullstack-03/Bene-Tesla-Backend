package com.sysmap.api.domain.model;

import java.util.UUID;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "users")

@Setter
@Getter
@Data
public class User {

  @Id
  private UUID id;
  private String name;
  private String email;
  private String password;
  private String photoUri;

  public User(String name, String email, String password) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.email = email;
    this.password = password;
  }

  public static User create(User user) {
    return new User(user.name, user.email, user.password);
  }

  public int getFollowers() {
    return +1;
  }

  public void setFollowers(int i) {
    for (int j = 0; j < i; j++) {
      i++;
    }
  }
}
