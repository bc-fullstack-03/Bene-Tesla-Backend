package com.sysmap.api.service.client.dto;
import com.sysmap.api.model.embedded.Author;
import lombok.Data;

@Data
public class CreateUserRequest {
  public String name;
  public String email;
  public String password;
  public Author author;

}
