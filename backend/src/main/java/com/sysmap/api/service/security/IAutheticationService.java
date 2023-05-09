package com.sysmap.api.service.security;

import com.sysmap.api.service.security.dto.AuthenticateRequeste;
import com.sysmap.api.service.security.dto.AuthenticateResponse;

public interface IAutheticationService {
    AuthenticateResponse authenticate(AuthenticateRequeste request) throws Exception;
}