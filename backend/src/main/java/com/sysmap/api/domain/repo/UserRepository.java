package com.sysmap.api.domain.repo;

import com.sysmap.api.domain.model.User;
import com.sysmap.api.service.client.dto.CreateUserRequest;
import java.util.Optional;
import java.util.UUID;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, UUID> {
  void save(CreateUserRequest user);
  Optional<User> findByEmail(String email);
  void deleteById(String id);
}
