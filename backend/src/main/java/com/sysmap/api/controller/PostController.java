package com.sysmap.api.controller;

import com.sysmap.api.service.post.IUserPostService;
import com.sysmap.api.service.post.dto.CreatePostRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class PostController {
    @Autowired
    private IUserPostService postService;
    @PostMapping("/post")
    public ResponseEntity<String> createPost(@RequestBody CreatePostRequest request) {
        var response = postService.createPost(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}