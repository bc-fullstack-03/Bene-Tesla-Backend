package com.sysmap.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.sysmap.api.service.client.IUservice;
import com.sysmap.api.service.client.dto.CreateUserRequest;
import com.sysmap.api.service.security.JwtService;

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
    private JwtService _jwtService;
    

    //String login(String email, String password)
    @GetMapping("/login/{email}/{password}")//http://localhost:8082/api/v1/user/login/{email}/{password}
    public ResponseEntity<String> login(@PathVariable("email") String email, @PathVariable("password") String password) {
        var response = _service.login(email, password);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request) {      
      if(_jwtService.isvalidToken(getToken(), getUserId())){
        return ResponseEntity.status(HttpStatus.OK).body("User already created");
       }
        var response = _service.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created"+ response);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        var res = _service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(res);
    }
    @GetMapping("/{email}")
    public ResponseEntity<String> getUser(@PathVariable("email") String email) {
        var response = _service.findByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }

   @PutMapping("/{id}")
    public ResponseEntity<String> updateUser(@PathVariable("id") String id, @RequestBody CreateUserRequest request) {
        var response = _service.updateUser(id, request);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/all")//http://localhost:8082/api/v1/user/all
    public ResponseEntity<String> getAll() {
        var response = _service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/follow/{name}")
        public ResponseEntity<Boolean> follow(@PathVariable("name") String name) {
        var response = _service.follow(name);
        return ResponseEntity.status(HttpStatus.OK).body(response);
        }

   public String getToken(){
    var request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
    var token = request.getHeader("Authorization");
    return token.substring(7);
   }
   public String getUserId(){
   return((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest().getHeader("userId");
   }
} 
