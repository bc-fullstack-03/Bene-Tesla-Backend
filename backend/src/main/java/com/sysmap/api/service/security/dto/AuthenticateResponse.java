package com.sysmap.api.service.security.dto;

import java.util.UUID;

import lombok.Data;

@Data
public class AuthenticateResponse {
    public UUID userId;
    public String token;
    
}
