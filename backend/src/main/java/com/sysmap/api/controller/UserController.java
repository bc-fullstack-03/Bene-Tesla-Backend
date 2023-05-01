package com.sysmap.api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysmap.api.service.client.IUservice;
import com.sysmap.api.service.client.dto.CreateUserRequest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    private IUservice _service;
    @GetMapping("/{id}")//http://localhost:8082/api/v1/user/{id}
    public ResponseEntity<String> getUser(@PathVariable("id") String id) {
        var response = _service.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response.toString());
    }
    @PostMapping("/create")//http://localhost:8082/api/v1/user/create
    public ResponseEntity<String> createUser(@RequestBody CreateUserRequest request) {
        var response = _service.createUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
    /*
     * @GetMapping("/teste")
     * public ResponseEntity<String> teste(){
     * return ResponseEntity.status(HttpStatus.CREATED).body("Testando o metodo get da sysmap api");
     * }
     */
    
    
        
}
