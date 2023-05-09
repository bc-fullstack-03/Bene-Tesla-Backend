package com.sysmap.api.service.client.dto;
import java.util.UUID;
import lombok.Data;

@Data
public class CreateUserResponse {
  public UUID id;
  public String name;
  public String email;
  public String photoUri;

  public CreateUserResponse(UUID id, String name, String email, String photoUri) {
      this.id = id;
      this.name = name;
      this.email = email;
      this.photoUri = photoUri;
  }
  }
