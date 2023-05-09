package com.sysmap.api.controller.auth;
import com.sysmap.api.service.security.IAutheticationService;
import com.sysmap.api.service.security.dto.AuthenticateResponse;
import com.sysmap.api.service.security.dto.AuthenticateRequeste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;

@RestController
@RequestMapping("/api/v1/user")
public class AuthController {

  @Autowired
  private IAutheticationService _authservice;
  @PostMapping()
    public ResponseEntity<AuthenticateResponse> authenticate(@RequestBody AuthenticateRequeste request) {
        try {
            return ResponseEntity.ok().body(_authservice.authenticate(request));
        } catch (Exception e) {
            return new ResponseEntity(e.getMessage(), HttpStatus.UNAUTHORIZED);
        }
    }
}
