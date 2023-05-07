package com.sysmap.api.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sysmap.api.service.comment.IcommentService;
import com.sysmap.api.service.comment.dto.CommentRequest;


@RestController
@RequestMapping("/api/v1")
public class CommentController {
    @Autowired
   private IcommentService _commentService;
    @PostMapping("/comment")
    public ResponseEntity<String> createCommentToPost(@RequestBody UUID postId, CommentRequest request){
        String result=_commentService.createCommentToPost(postId, request);
        return new ResponseEntity<String>(result,HttpStatus.OK);
    }
    @GetMapping("/comment/{postId}/{commentId}")//localhost:8080/api/v1/comment
    public ResponseEntity<String> findById(String postId, String commentId){
        String result=_commentService.findById(postId, commentId);
        return new ResponseEntity<String>(result,HttpStatus.OK);
    }
   
    @PutMapping("/comment/{postId}/{commentId}")//localhost:8080/api/v1/comment
    public ResponseEntity<String> updateCommentToPost(@RequestBody CommentRequest commentRequest, String postId, String commentId){
        String result=_commentService.updateCommentToPost(postId, commentId, commentRequest);
        return new ResponseEntity<String>(result,HttpStatus.OK);
    }
   @DeleteMapping("/comment/{postId}/{commentId}")//localhost:8080/api/v1/comment
   public ResponseEntity<String> deleteCommentToPost(String postId, String commentId){
    String result=_commentService.deleteCommentToPost(postId, commentId);
    return new ResponseEntity<String>(result,HttpStatus.OK);
   } 
}
    
    

