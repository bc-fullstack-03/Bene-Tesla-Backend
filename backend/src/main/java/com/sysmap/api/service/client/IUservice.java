package com.sysmap.api.service.client;

import java.util.Optional;

import com.sysmap.api.service.client.dto.CreateUserRequest;
import com.sysmap.api.service.client.dto.CreateUserResponse;

public interface IUservice {
   Optional<CreateUserResponse> findById(String id);
   String createUser(CreateUserRequest request);
    
}
