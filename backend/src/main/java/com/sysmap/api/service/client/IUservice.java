package com.sysmap.api.service.client;


import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;
import com.sysmap.api.domain.model.User;
import com.sysmap.api.service.client.dto.CreateUserRequest;
import com.sysmap.api.service.client.dto.CreateUserResponse;
public interface IUservice {      
   String createUser(CreateUserRequest user);
   String findAll();
   String updateUser(String id, CreateUserRequest request);
   ResponseEntity<?> delete(String email);
   CreateUserResponse findUserByEmail(String email);  
   User getUserById(UUID id);
   User getUserByEmail(String email);   
   boolean follow(String name);  
   void uploadPhotoProfile(MultipartFile photo) throws Exception;  
  
}
