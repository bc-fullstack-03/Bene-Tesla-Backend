package com.sysmap.api.middleware;

import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.sysmap.api.service.client.security.IJwtService;
@RestController
public class ValidateUser {
    private IJwtService jwtService;
    public ValidateUser(){
        if(jwtService == null){
            jwtService = new IJwtService() {
                @Override
                public String generateToken(UUID userId) {
                    return ResponseEntity.ok().build().toString();
                }

                @Override
                public boolean isvalidToken(String token, UUID userId) {
                    if(token == null || userId == null){
                        return false;
                    }else{
                        return true;
                    }
                }

                
            };
        }
    }
}
