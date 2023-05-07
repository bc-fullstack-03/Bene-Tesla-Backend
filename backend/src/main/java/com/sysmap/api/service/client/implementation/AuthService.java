package com.sysmap.api.service.client.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmap.api.service.client.dto.AuthenticateRequest;
import com.sysmap.api.service.client.dto.AuthenticateResponse;
import com.sysmap.api.service.security.JwtService;
import com.sysmap.api.service.security.authentication.IAuthService;
@Service
public class AuthService implements IAuthService {
    @Autowired
    private UserService _userService;
    @Autowired
    private JwtService _jwtService;
    @Override
    public AuthenticateResponse authenticate(AuthenticateRequest request) {
        var user = _userService.findByEmail(request.email);
        if(user == null) {
            return null;
        }
        var token = _jwtService.generateToken(user.getId());
        var response = new AuthenticateResponse();
        response.setId(user.getId());
        response.setToken(token);
        return response;
    }
}