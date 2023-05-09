package com.sysmap.api.service.client;

import java.util.UUID;

import org.springframework.web.multipart.MultipartFile;

import com.sysmap.api.domain.model.User;
import com.sysmap.api.service.client.dto.CreateUserRequest;
public interface IUservice {      
   String createUser(CreateUserRequest user);
   String findAll();
   String updateUser(String id, CreateUserRequest request);
   User findByEmail(String email);
   boolean follow(String name);  
   void uploadPhotoProfile(MultipartFile photo) throws Exception;
   Object getUserById(UUID fromString);
   User getUser(String email);
}
