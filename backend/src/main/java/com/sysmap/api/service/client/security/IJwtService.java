package com.sysmap.api.service.client.security;

import java.util.UUID;

public interface IJwtService {
    String generateToken(UUID userId);  
}
