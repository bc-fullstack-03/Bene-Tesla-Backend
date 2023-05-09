package com.sysmap.api.service.security;

import com.sysmap.api.service.authentication.dto.AuthenticateResponse;
import com.sysmap.api.service.authentication.dto.AutheticateRequeste;

public interface IAuthService {
    AuthenticateResponse authenticate(AutheticateRequeste request) throws Exception;
}