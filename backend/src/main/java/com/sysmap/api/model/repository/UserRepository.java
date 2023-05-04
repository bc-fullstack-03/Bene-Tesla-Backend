package com.sysmap.api.model.repository;

import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;
import com.sysmap.api.model.entities.User;
import com.sysmap.api.service.client.dto.CreateUserRequest;

public interface UserRepository extends MongoRepository<User, UUID> {
    void save(CreateUserRequest _user);
    Optional<User> findByEmail(String email);    
    void deleteById(String id);
}