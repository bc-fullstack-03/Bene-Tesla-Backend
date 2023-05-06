package com.sysmap.api.service.client.dto;
import java.util.UUID;
import lombok.Data;

@Data
public class CreateUserResponse {
  private UUID id;
  public String name;
  public String email;
  public String password;

  public CreateUserResponse(String string, String name, String email, String password) {
    this.id = UUID.randomUUID();
    this.name = name;
    this.email = email;
    this.password = password;
  }
}