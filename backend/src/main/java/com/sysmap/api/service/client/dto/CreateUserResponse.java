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

  public CreateUserResponse(UUID id, String name, String email, Author author) {
    this.id = id;
    this.name = name;
    this.email = email;
    this.author = author;
  }
}
