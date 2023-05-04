package com.sysmap.api.controller;

import com.sysmap.api.service.client.authentication.IAuthService;
import com.sysmap.api.service.client.dto.AuthenticateRequest;
import com.sysmap.api.service.client.dto.AuthenticateResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class AuthController {

  @Autowired
  private IAuthService _authservice;
  @PostMapping("/authenticate")
  public ResponseEntity<AuthenticateResponse> authenticate(
    @RequestBody AuthenticateRequest request
  ) {
    _authservice.authenticate(request);
    return ResponseEntity.ok().body(_authservice.authenticate(request));
  }
}
