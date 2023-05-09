package com.sysmap.api.service.security.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sysmap.api.service.authentication.IJwtService;
import com.sysmap.api.service.authentication.dto.AuthenticateResponse;
import com.sysmap.api.service.authentication.dto.AutheticateRequeste;
import com.sysmap.api.service.client.IUservice;
import com.sysmap.api.service.security.IAuthService;

@Service
public class AuthService implements IAuthService {

    
    @Autowired
    private IUservice  _userService;
    @Autowired
    private IJwtService _jwtService;
    @Autowired
    private PasswordEncoder _passwordEncoder;

    public AuthenticateResponse authenticate(AutheticateRequeste request) throws Exception {
        var user = _userService.getUser(request.email);

        if (user == null) {
            return null;
        }

        if (!_passwordEncoder.matches(request.password, user.getPassword())) {
            throw new Exception("Invalid credentials");
        }

        var token = _jwtService.generateToken(user.getId());

        var response = new AuthenticateResponse();

        response.setUserId(user.getId());
        response.setToken(token);

        return response;
    }
}