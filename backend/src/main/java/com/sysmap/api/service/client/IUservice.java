package com.sysmap.api.service.client;
import com.sysmap.api.service.client.dto.CreateUserRequest;

public interface IUservice {   
   String deleteById(String id);
   String createUser(CreateUserRequest request);
   String findAll();
   Object findByEmail(String email);
   
}
