package com.sysmap.api.controller;

import com.sysmap.api.service.client.dto.AuthenticateRequest;
import com.sysmap.api.service.client.dto.AuthenticateResponse;
import com.sysmap.api.service.security.authentication.IAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/v1/user")
public class AuthController {

  @Autowired
  private IAuthService _authservice;
  @PostMapping("/authenticate")//http://localhost:8082/api/v1/user/authenticate
  public ResponseEntity<AuthenticateResponse> authenticate(
    @RequestBody AuthenticateRequest request
  ) {
    _authservice.authenticate(request);
    return ResponseEntity.ok().body(_authservice.authenticate(request));
  }
}
