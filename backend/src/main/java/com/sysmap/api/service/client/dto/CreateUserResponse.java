package com.sysmap.api.service.client.dto;

import com.sysmap.api.model.embedded.Author;
import java.util.UUID;
import lombok.Data;

@Data
public class CreateUserResponse {
  private UUID id;
  public String name;
  public String email;
  public Author author;

  public CreateUserResponse(String string, String name, String email, String password, Author author) {
    this.id = UUID.fromString(string);
    this.name = name;
    this.email = email;
    this.author = author;
  }
}
