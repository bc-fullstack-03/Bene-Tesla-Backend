package com.sysmap.api.service.client.dto;


import java.util.UUID;

import lombok.Data;

@Data
public class CreateUserRequest {
  public UUID id;
  public String email;
  public String name;
  public String password; 
  public UUID userCreatedTO;
}
