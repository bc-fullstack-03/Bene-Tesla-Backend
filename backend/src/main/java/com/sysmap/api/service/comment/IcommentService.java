package com.sysmap.api.service.comment;

import java.util.UUID;

import com.sysmap.api.service.comment.dto.CommentRequest;

public interface IcommentService {  
    String createCommentToPost(UUID postId, CommentRequest request);
    String findById(String postId, String commentId);
    String updateCommentToPost(String postId, String commentId, CommentRequest dataToUpdate);
    String deleteCommentToPost(String postId, String commentId);
}
