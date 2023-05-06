package com.sysmap.api.service.comment.implementation;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.sysmap.api.service.comment.IcommentService;
import com.sysmap.api.service.comment.dto.CommentRequest;
import com.sysmap.api.service.embedded.Comment;

@Service
public class CommentService  implements IcommentService{

  @Override
  public String createCommentToPost(UUID postId, CommentRequest request) {
    var comment = new Comment(request.getBody(), postId);
    //eventService.consumer(comment);
    return comment.getId().toString();
        
    
  }

  @Override
  public String findById(String postId, String commentId) {
    if(commentId != null) {
      return "comment found";
    }else {
      return "The comment does not exist";
    }

  }

  @Override
  public String updateCommentToPost(String postId, String commentId, CommentRequest dataToUpdate) {
    if(commentId != null) {
      return "comment updated";
    }else {
      return "The comment does not exist";
    }
  }

  

  @Override
  public String deleteCommentToPost(String postId, String commentId) {
    if(commentId != null) {
      return "comment deleted";
    }else {
      return "The comment does not exist";
    }  
  }
  
}
