package com.sysmap.api.service.client.implementation;

import com.sysmap.api.model.embedded.Author;
import com.sysmap.api.model.entities.User;
import com.sysmap.api.model.repository.UserRepository;
import com.sysmap.api.service.client.IUservice;
import com.sysmap.api.service.client.IveEventService;
import com.sysmap.api.service.client.dto.CreateUserRequest;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public final class UserService implements IUservice {

  @Autowired
  private UserRepository repo;

  @Autowired
  private IveEventService eventService;

  public String createUser(CreateUserRequest request) {
    try {
      var author = new Author(request.author);
      var user = new User(
        request.name,
        request.email,
        request.password,
        author
      );
      repo.save(user);
      eventService.send(user.getId().toString());
      return user.getId().toString();
    } catch (Exception e) {
      return e.getMessage();
    }
  }

  public User findByEmail(String email) {
    var user = repo.findByEmail(email);
    var response = new User(
      user.get().getName(),
      user.get().getEmail(),
      user.get().getPassword(),
      user.get().getAuthor()
    );
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

  
}
