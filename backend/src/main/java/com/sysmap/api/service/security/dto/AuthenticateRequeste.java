package com.sysmap.api.service.security.dto;

import lombok.Data;

@Data
public class AuthenticateRequeste {
    public String email;
    public String password;
}
