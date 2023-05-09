package com.sysmap.api.service.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.sysmap.api.service.security.dto.AuthenticateResponse;
import com.sysmap.api.service.authentication.IJwtService;
import com.sysmap.api.service.client.IUservice;
import com.sysmap.api.service.security.dto.AuthenticateRequeste;

@Service
public class AutheticationService implements IAutheticationService {

    @Autowired
    private IUservice _userService;
    @Autowired
    private IJwtService _jwtService;
    @Autowired
    private PasswordEncoder _passwordEncoder;

    public AuthenticateResponse authenticate(AuthenticateRequeste request) throws Exception {
        var user = _userService.getUserByEmail(request.email);

        if (user == null) {
            return null;
        }

        if (!_passwordEncoder.matches(request.password, user.getPassword())) {
            throw new Exception("Credenciais inválidas!");
        }

        var token = _jwtService.generateToken(user.getId());

        var response = new AuthenticateResponse();

        response.setUserId(user.getId());
        response.setToken(token);

        return response;
    }
}
