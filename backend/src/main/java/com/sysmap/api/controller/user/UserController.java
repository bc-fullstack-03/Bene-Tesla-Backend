package com.sysmap.api.controller.user;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.sysmap.api.service.authentication.IJwtService;
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

  @Autowired
  private IJwtService _jwtService;

  @PostMapping("/create")//http://localhost:8082/api/v1/user/create
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest user) {     
      
        var response = _service.createUser(user);
        return ResponseEntity.status(HttpStatus.OK).body("User already created" + response);
    }

  @PostMapping("/photo/upload") //http://localhost:8082/api/v1/user/photo/upload
  public ResponseEntity uploadPhotoProfile(
    @RequestParam("photo") MultipartFile photo
  ) {
    try {
      _service.uploadPhotoProfile(photo);

      return new ResponseEntity(HttpStatus.OK);
    } catch (Exception e) {
      return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/{email}")
  public ResponseEntity<Object> getUser(@PathVariable("email") String email) {
    var response = _service.findByEmail(email);
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

  @GetMapping("/all") //http://localhost:8082/api/v1/user/all
  public ResponseEntity<String> getAll() {
    var response = _service.findAll();
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }

  @GetMapping("/follow/{name}")
  public ResponseEntity<Boolean> follow(@PathVariable("name") String name) {
    var response = _service.follow(name);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
  /*
   *  public String getToken(){
    var request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    var token = request.getHeader("Authorization");
    return token.substring(7);
   }
   public String getUserId(){
   return((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("userId");
   }
   */
 
  
}
