package com.sysmap.api.service.client.implementation;

import com.sysmap.api.model.entities.User;
import com.sysmap.api.model.repository.UserRepository;
import com.sysmap.api.service.client.IUservice;
import com.sysmap.api.service.client.dto.CreateUserRequest;
import com.sysmap.api.service.embedded.Author;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public final class UserService implements IUservice {

  @Autowired
  private UserRepository repo;

  //private IveEventService eventService;
  @Autowired
  private PasswordEncoder passwordEncoder;

  public String createUser(CreateUserRequest request) {
    var author = new Author(request.getAuthor());
    var user = new User(request.getEmail(), author);
    if (repo.findByEmail(request.getEmail()).isPresent()) {
      return "User already exists";
    }
    var hash = passwordEncoder.encode(request.password);
    user.getAuthor().setPassword(hash);
    repo.save(user);
    return user.getId().toString();
  }

  public User findByEmail(String email) {
    var user = repo.findByEmail(email);
    var response = new User(user.get().getEmail(), user.get().getAuthor());
    response.setId(user.get().getId());
    return response;
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

  public boolean follow(String id, String idToFollow) {
    UUID uuid = UUID.fromString(id);
    UUID uuidToFollow = UUID.fromString(idToFollow);
    var user = repo.findById(uuid);
    var userToFollow = repo.findById(uuidToFollow);
    if (user.isPresent() && userToFollow.isPresent()) {
      user.get().getAuthor().follow(userToFollow.get().getAuthor());
      repo.save(user.get());
      return true;
    }
    return false;
  }
}
