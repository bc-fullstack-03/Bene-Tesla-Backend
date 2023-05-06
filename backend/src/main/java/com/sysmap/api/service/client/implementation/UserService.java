package com.sysmap.api.service.client.implementation;

import com.sysmap.api.interfaces.repositories.UserRepository;
import com.sysmap.api.model.entities.User;
import com.sysmap.api.service.client.IUservice;
import com.sysmap.api.service.client.dto.CreateUserRequest;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public final class UserService implements IUservice {

  @Autowired
  private UserRepository repo;

  @Autowired
  private PasswordEncoder passwordEncoder;

  public String createUser(CreateUserRequest request) {
    var user = new User(request.getName(), request.getEmail(),  request.getPassword());
    var hash = passwordEncoder.encode(user.getPassword());
    user.setPassword(hash);
    repo.save(user);
    return ResponseEntity.ok("User created successfully").toString();
  }

  public User findByEmail(String email) {
    var query = repo.findByEmail(email);
    if (query.isPresent()) {
      return query.get();
    }
    return null;
  }

  public String findAll() {
    var users = repo.findAll();
    return users.toString();
  }

  public String deleteById(String id) {
    UUID uuid = UUID.fromString(id);
    try {
      repo.deleteById(uuid);
      return "User deleted";
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  public boolean follow(String name) {
    var user = findByEmail(name);
    if (user != null) {
      user.setFollowers(user.getFollowers() + 1);
      repo.save(user);
      return true;
    }
    return false;
  }
}
