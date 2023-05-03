package com.sysmap.api.service.client.implementation;

import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sysmap.api.model.embedded.Author;
import com.sysmap.api.model.entities.User;
import com.sysmap.api.model.repository.UserRepository;
import com.sysmap.api.service.client.IUservice;
import com.sysmap.api.service.client.IveEventService;
import com.sysmap.api.service.client.dto.CreateUserRequest;
import com.sysmap.api.service.client.dto.CreateUserResponse;

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
    }
    catch (Exception e) {
      return e.getMessage();
    }
  }

  @Override
  public Optional<CreateUserResponse> findById(String id) {
    UUID uuid = UUID.fromString(id);
    var queryUser = repo.findById(uuid);
    var user = queryUser.map(u ->
      new CreateUserResponse(
        u.getId().toString(),
        u.getName(),
        u.getEmail(),
        u.getPassword(),
        u.getAuthor()
      )
    );
    return user;
  }
  
  
}
