package com.sysmap.api.service.security;

import java.util.UUID;

public interface IJwtService {
    String generateToken(UUID userId);
    boolean isvalidToken(String token, String userId);
}
