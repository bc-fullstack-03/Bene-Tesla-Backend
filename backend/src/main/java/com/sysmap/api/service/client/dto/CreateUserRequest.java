package com.sysmap.api.service.client.dto;

import lombok.Data;

@Data
public class CreateUserRequest {
  public String email;
  public String name;
  public String password;
 

}
