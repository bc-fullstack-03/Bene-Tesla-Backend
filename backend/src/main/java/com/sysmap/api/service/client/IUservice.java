package com.sysmap.api.service.client;
import com.sysmap.api.service.client.dto.CreateUserRequest;
public interface IUservice {   
   String deleteById(String id);
   String createUser(CreateUserRequest user);
   String findAll();
   String updateUser(String id, CreateUserRequest request);
   String login(String email, String password);
   Object findByEmail(String email);
   boolean follow(String name);
   
}
