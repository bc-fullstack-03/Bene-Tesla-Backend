package com.sysmap.api.service.security.authentication;

import com.sysmap.api.service.client.dto.AuthenticateRequest;
import com.sysmap.api.service.client.dto.AuthenticateResponse;

public interface IAuthService {
    AuthenticateResponse authenticate(AuthenticateRequest request);
}