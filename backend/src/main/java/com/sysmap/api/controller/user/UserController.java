package com.sysmap.api.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import com.sysmap.api.service.client.IUservice;
import com.sysmap.api.service.client.dto.CreateUserRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;


@RestController
@RequestMapping("/api/v1/user")
public class UserController {

  @Autowired
  private IUservice _service;

  @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest user) {     
        var response = _service.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User already created" + response);
    }

  @PostMapping("/photo/upload")
  public ResponseEntity<String> uploadPhotoProfile(@RequestParam("photo") MultipartFile photo) throws Exception {
    try {
      _service.uploadPhotoProfile(photo);
      return ResponseEntity.status(HttpStatus.OK).body("Photo uploaded");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
  }

  @GetMapping("/{email}")
  public ResponseEntity<Object> getUser(@PathVariable("email") String email) {
    var response = _service.findUserByEmail(email);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateUser(
    @PathVariable("id") String id,
    @RequestBody CreateUserRequest request
  ) {
    var response = _service.updateUser(id, request);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUser(@PathVariable("id") String id) {
    var response = _service.delete(id);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
  @GetMapping("/all") 
  public ResponseEntity<String> getAll() {
    var response = _service.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/follow/{name}")
  public ResponseEntity<Boolean> follow(@PathVariable("name") String name) {
    var response = _service.follow(name);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }  
}
