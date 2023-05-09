package com.sysmap.api.controller.auth;

import com.sysmap.api.service.authentication.dto.AuthenticateResponse;
import com.sysmap.api.service.authentication.dto.AutheticateRequeste;
import com.sysmap.api.service.security.IAuthService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@CrossOrigin(allowedHeaders = "*", origins = "*")
@RequestMapping("/api/v1/user")
public class AuthController {

  @Autowired
  private IAuthService _authservice;
  @PostMapping("/authentication")//http://localhost:8082/api/v1/user/authentication
  public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AutheticateRequeste request) {
    try {
      var response = _authservice.authenticate(request);
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
    }
    
  }
}
