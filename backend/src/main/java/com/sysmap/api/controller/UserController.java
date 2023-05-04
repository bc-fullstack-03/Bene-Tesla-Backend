package com.sysmap.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysmap.api.middleware.ValidateUser;
import com.sysmap.api.service.client.IUservice;
import com.sysmap.api.service.client.dto.CreateUserRequest;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/user")
public class UserController extends ValidateUser {
    @Autowired
    private IUservice _service;   
    
    @PostMapping("/create")//http://localhost:8082/api/v1/user/create/createUser
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request) {
        var response = _service.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    @DeleteMapping("/{id}")//http://localhost:8082/api/v1/user/{id}
    public ResponseEntity<String> deleteUser(@PathVariable("id") String id) {
        var response = _service.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
    @GetMapping("/{email}")//http://localhost:8082/api/v1/user/{email}
    public ResponseEntity<String> getUser(@PathVariable("email") String email) {
        var response = _service.findByEmail(email);
        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }
    @GetMapping("/all")//http://localhost:8082/api/v1/user/all
    public ResponseEntity<String> getAll() {
        var response = _service.findAll();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
