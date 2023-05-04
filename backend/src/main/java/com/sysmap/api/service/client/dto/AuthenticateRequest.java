package com.sysmap.api.service.client.dto;

import lombok.Data;

@Data
public class AuthenticateRequest {
    public String email;
    public String password;
}
