package com.sysmap.api.service.client.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class AuthenticateResponse {
  public UUID id;
  public String token;
}
