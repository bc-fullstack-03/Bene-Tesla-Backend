package com.sysmap.api.controller;
import com.sysmap.api.model.entities.Post;
import com.sysmap.api.service.post.IUserPostService;
import com.sysmap.api.service.post.dto.CreatePostRequest;
import com.sysmap.api.service.post.dto.CreatePostResponse;

import io.swagger.v3.oas.annotations.parameters.RequestBody;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
@RequestMapping("/api/v1")
public class PostController {

  @Autowired
  private IUserPostService postService;

  @PostMapping("/post")
  public ResponseEntity<String> createPost(@RequestBody CreatePostRequest request) {
    var response = postService.createPost(request);
    return ResponseEntity.status(HttpStatus.OK).body(response);
  }
  @DeleteMapping("/post/delete")
  public ResponseEntity<String> deletePost(String postId) throws Exception {
    postService.deletePost(postId);
    return ResponseEntity.status(HttpStatus.OK).body("Post deleted");
  }
  @PutMapping("/post/update")
  public ResponseEntity<String> updatePost(String postId, CreatePostRequest dataToUpdate) throws Exception {
    postService.updatePost(postId, dataToUpdate);
    return ResponseEntity.status(HttpStatus.OK).body("Post updated");
  }
  @GetMapping("/posts/list/user")
  public ResponseEntity<List<Post>> findPosts(CreatePostResponse response) {
    var resp= postService.findPosts(response);
    return ResponseEntity.status(HttpStatus.OK).body(resp);
  }
  
}
